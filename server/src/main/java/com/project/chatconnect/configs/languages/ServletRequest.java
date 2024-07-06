package com.project.chatconnect.configs.languages;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * The type Servlet request.
 * Author: Huy Dang
 */
public class ServletRequest {
    /**
     * Gets current request.
     *
     * @return the current request
     */
    public static HttpServletRequest getCurrentRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }
}
