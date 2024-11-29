package com.project.chatconnect.utility;

import com.project.chatconnect.applications.repositories.LogEntryRepository;
import com.project.chatconnect.configs.security.CustomUserDetails;
import com.project.chatconnect.domains.enities.LogEntry;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.text.MessageFormat;
import java.util.Map;

/**
 * The type General log utility.
 */
@Component
public class GeneralLogUtility {
    /**
     * The General log format.
     */
    protected final String GENERAL_LOG_FORMAT;

    private final LogEntryRepository logEntryRepository;

    /**
     * Instantiates a new General log utility.
     *
     * @param logEntryRepository the log entry repository
     * @param auditorAware       the auditor aware
     */
    @Autowired
    public GeneralLogUtility(LogEntryRepository logEntryRepository) {
        this.logEntryRepository = logEntryRepository;
        GENERAL_LOG_FORMAT = "SessionId: {0}, EventType: {1}, UserId: {2}, IPAddress: {3}, Details: {4}";
    }

    /**
     * Write log.
     *
     * @param logger    the logger
     * @param eventType the event type
     * @param details   the details
     */
    public void writeLog(Logger logger, String eventType, Map<String, Object> details) {
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String ipAddress = request.getRemoteAddr();
        String userId = "anonymous_user";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails customUserDetails) {
            userId = customUserDetails.getUser().getId();
        }
        String sessionId = request.getSession().getId();
        String eventLogMsg =
                MessageFormat.format(GENERAL_LOG_FORMAT, sessionId, eventType, userId, ipAddress, details);
        logger.info(eventLogMsg);
        saveLog(request, eventType, userId);
    }

    private void saveLog(HttpServletRequest request, String eventType, String userId) {
        LogEntry logEntry = new LogEntry();

        String ipAddress = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        String api = request.getRequestURI();

        logEntry.setType(eventType);
        logEntry.setIpAddress(ipAddress);
        logEntry.setApi(api);
        logEntry.setUserId(userId);
        logEntry.setUserAgent(userAgent);
        logEntryRepository.save(logEntry);
    }
}
