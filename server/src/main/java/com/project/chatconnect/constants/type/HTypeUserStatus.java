package com.project.chatconnect.constants.type;

import com.project.chatconnect.utility.EnumTypeUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum User status.
 *
 * @author Huy Dang
 */
@Getter
@AllArgsConstructor
public enum HTypeUserStatus implements EnumType {
    /**
     * Active user status.
     */
    ACTIVE("Active", "1"),
    /**
     * Inactive user status.
     */
    INACTIVE("Inactive", "2"),
    /**
     * Deleted user status.
     */
    DELETED("Deleted", "3"),
    /**
     * Blocked user status.
     */
    BLOCKED("Blocked", "4"),
    /**
     * Need verify user status.
     */
    NEED_VERIFY("Need verify", "5");

    /**
     * Of h type user status.
     *
     * @param value the value
     * @return the h type user status
     */
    public static HTypeUserStatus of(String value) {
        HTypeUserStatus hType = EnumTypeUtility.getEnumFromValue(HTypeUserStatus.class, value);

        if (hType == null) {
            throw new IllegalArgumentException(value);
        }
        return hType;
    }

    private final String label;

    private final String value;
}
