package com.project.chatconnect.domains.enums.user;

import lombok.Getter;

/**
 * The enum User status.
 * Author: Huy Dang
 */
@Getter
public enum UserStatus {
    /**
     * Active user status.
     */
    ACTIVE("active"),
    /**
     * Inactive user status.
     */
    INACTIVE("inactive"),
    /**
     * Deleted user status.
     */
    DELETED("deleted"),
    /**
     * Blocked user status.
     */
    BLOCKED("blocked"),
    /**
     * Need verify user status.
     */
    NEED_VERIFY("need_verify");

    private final String status;

    UserStatus(String status) {
        this.status = status;
    }
}
