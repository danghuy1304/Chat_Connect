package com.project.chatconnect.domains.enums.user;

import lombok.Getter;

/**
 * The enum User status image.
 *
 * @author Huy Dang
 */
@Getter
public enum UserStatusImage {
    /**
     * Active user status image.
     */
    ACTIVE("active"),
    /**
     * Inactive user status image.
     */
    INACTIVE("inactive");

    private final String status;

    UserStatusImage(String status) {
        this.status = status;
    }
}
