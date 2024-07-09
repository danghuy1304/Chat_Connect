package com.project.chatconnect.domains.enums.post;

import lombok.Getter;

/**
 * The enum Access modifier.
 *
 * @author Huy Dang
 */
@Getter
public enum AccessModifier {
    /**
     * Public access modifier.
     */
    PUBLIC("public"),
    /**
     * Private access modifier.
     */
    PRIVATE("private"),
    /**
     * Friend access modifier.
     */
    FRIEND("friend"),
    /**
     * Group access modifier.
     */
    GROUP("group"),
    /**
     * Specific access modifier.
     */
    SPECIFIC("specific"),
    /**
     * Settings access modifier.
     */
    SETTINGS("settings");

    private final String value;

    AccessModifier(String value) {
        this.value = value;
    }
}
