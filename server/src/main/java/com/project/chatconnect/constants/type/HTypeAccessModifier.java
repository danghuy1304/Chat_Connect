package com.project.chatconnect.constants.type;

import com.project.chatconnect.utility.EnumTypeUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Access modifier.
 *
 * @author Huy Dang
 */
@Getter
@AllArgsConstructor
public enum HTypeAccessModifier implements EnumType {
    /**
     * Public access modifier.
     */
    PUBLIC("Public", "1"),
    /**
     * Private access modifier.
     */
    PRIVATE("Private", "2"),
    /**
     * Friend access modifier.
     */
    FRIEND("Friend", "3"),
    /**
     * Group access modifier.
     */
    GROUP("Group", "4"),
    /**
     * Specific access modifier.
     */
    SPECIFIC("Specific", "5"),
    /**
     * Settings access modifier.
     */
    SETTINGS("Settings", "6");

    public static HTypeAccessModifier of(String value) {
        HTypeAccessModifier hType = EnumTypeUtility.getEnumFromValue(HTypeAccessModifier.class, value);

        if (hType == null) {
            throw new IllegalArgumentException(value);
        }
        return hType;
    }

    private final String label;

    private final String value;
}
