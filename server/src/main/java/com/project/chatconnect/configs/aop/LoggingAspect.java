package com.project.chatconnect.configs.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * The type Logging aspect.
 *
 * @author Huy Dang
 */
@Component
@Aspect
@Log4j2
public class LoggingAspect {
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
        return joinPoint.proceed();
    }
}
