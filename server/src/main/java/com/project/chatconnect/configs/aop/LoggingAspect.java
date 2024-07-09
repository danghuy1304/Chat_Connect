package com.project.chatconnect.configs.aop;

import com.project.chatconnect.applications.repositories.LogEntryRepository;
import com.project.chatconnect.domains.enities.LogEntry;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;

/**
 * The type Logging aspect.
 *
 * @author Huy Dang
 */
@Component
@Aspect
@Log4j2
public class LoggingAspect {
    private final LogEntryRepository logEntryRepository;

    private final AuditorAware<String> auditorAware;

    /**
     * Inject dependencies.
     *
     * @param logEntryRepository the log entry repository
     * @param auditorAware       the auditor aware
     */
    @Autowired
    public LoggingAspect(LogEntryRepository logEntryRepository, AuditorAware<String> auditorAware) {
        this.logEntryRepository = logEntryRepository;
        this.auditorAware = auditorAware;
    }

    /**
     * Controller methods.
     */
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *) " +
            "&& execution(* com.project.chatconnect.web.controllers..*(..))")
    public void controllerMethods() {
    }

    /**
     * Log after returning.
     *
     * @param result the result
     */
    @AfterReturning(pointcut = "controllerMethods()", returning = "result")
    public void logAfterReturning(Object result) {
        log.info("API_SUCCESS - RESPONSE: {}", result);
    }

    /**
     * Log after throwing.
     *
     * @param error the error
     */
    @AfterThrowing(pointcut = "controllerMethods()", throwing = "error")
    public void logAfterThrowing(Throwable error) {
        log.info("API_ERROR - ERROR: {}", error.getMessage());
    }

    /**
     * Log around object.
     *
     * @param joinPoint the join point
     * @return the object
     * @throws Throwable the throwable
     */
    @Around("controllerMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes()).getRequest();
        String controllerName = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String ipAddress = request.getRemoteAddr();
        String url = request.getRequestURI();
        log.info("API_REQUEST - CONTROLLER: {}, METHOD: {}, URL: {}, IP: {}", controllerName, methodName, url,
                ipAddress);
        try {
            Object result = joinPoint.proceed();
            this.logging(joinPoint, "SUCCESS", result, null);
            return result;
        } catch (Throwable throwable) {
            log.error("API_ERROR - ERROR: {}", throwable.getMessage());
            this.logging(joinPoint, "ERROR", null, throwable.getMessage());
            throw throwable;
        }
    }

    /**
     * Logging into database.
     *
     * @param joinPoint the join point
     * @param status    the log status
     * @param response  the response
     * @param error     the error
     */
    private void logging(JoinPoint joinPoint, String status, Object response, String error) {
        LogEntry logEntry = new LogEntry();
        String currentUsername = auditorAware.getCurrentAuditor().orElse("unknown_user");
        String methodName = joinPoint.getSignature().getName();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes()).getRequest();
        String userAgent = request.getHeader("User-Agent");
        String controllerName = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String ipAddress = request.getRemoteAddr();
        String api = request.getRequestURI();
        logEntry.setController(controllerName);
        logEntry.setMethod(methodName);
        logEntry.setApi(api);
        logEntry.setIpAddress(ipAddress);
        logEntry.setUserName(currentUsername);
        logEntry.setUserAgent(userAgent);
        logEntry.setStatus(status);
        logEntry.setResponse(response);
        logEntry.setLogTime(LocalDateTime.now());
        logEntry.setError(error);
        logEntryRepository.save(logEntry);
    }
}
