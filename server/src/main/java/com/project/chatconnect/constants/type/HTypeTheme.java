package com.project.chatconnect.constants.type;

import com.project.chatconnect.utility.EnumTypeUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Theme type.
 *
 * @author Huy Dang
 */
@Getter
@AllArgsConstructor
public enum HTypeTheme implements EnumType {
    /**
     * Dark mode.
     */
    DARK("Dark", "1"),
    /**
     * Light mode.
     */
    LIGHT("Light", "2"),
    /**
     * System mode.
     */
    SYSTEM("System", "3");

    /**
     * Of h type theme.
     *
     * @param value the value
     * @return the h type theme
     */
    public static HTypeTheme of(String value) {
        HTypeTheme hType = EnumTypeUtility.getEnumFromValue(HTypeTheme.class, value);

        if (hType == null) {
            throw new IllegalArgumentException(value);
        }
        return hType;
    }

    private final String label;

    private final String value;
}
