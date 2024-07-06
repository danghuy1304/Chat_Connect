package com.project.chatconnect.applications.constants;

import org.springframework.stereotype.Component;

/**
 * The type Security constant.
 * Author: Huy Dang
 */
@Component
public class SecurityConstant {
    private SecurityConstant() {
    }

    /**
     * The constant TOKEN_PREFIX.
     */
    public static final String TOKEN_PREFIX = "Bearer ";
    /**
     * The constant HEADER_AUTHORIZATION.
     */
    public static final String HEADER_AUTHORIZATION = "Authorization";
}
