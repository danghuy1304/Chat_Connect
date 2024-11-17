package com.project.chatconnect.constants.type;

import com.project.chatconnect.utility.EnumTypeUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum User status image.
 *
 * @author Huy Dang
 */
@Getter
@AllArgsConstructor
public enum HTypeUserStatusImage implements EnumType {
    /**
     * Active user status image.
     */
    ACTIVE("Active", "1"),
    /**
     * Inactive user status image.
     */
    INACTIVE("Inactive", "2");

    /**
     * Of h type user status image.
     *
     * @param value the value
     * @return the h type user status image
     */
    public static HTypeUserStatusImage of(String value) {
        HTypeUserStatusImage hType = EnumTypeUtility.getEnumFromValue(HTypeUserStatusImage.class, value);

        if (hType == null) {
            throw new IllegalArgumentException(value);
        }
        return hType;
    }

    private final String label;

    private final String value;
}
