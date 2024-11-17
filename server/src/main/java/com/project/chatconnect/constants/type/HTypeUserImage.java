package com.project.chatconnect.constants.type;

import com.project.chatconnect.utility.EnumTypeUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum User image type.
 *
 * @author Huy Dang
 */
@Getter
@AllArgsConstructor
public enum HTypeUserImage implements EnumType {
    /**
     * Avatar user image type.
     */
    AVATAR("Avatar", "1"),
    /**
     * Cover user image type.
     */
    COVER("Cover", "2");

    /**
     * Of h type user image.
     *
     * @param value the value
     * @return the h type user image
     */
    public static HTypeUserImage of(String value) {
        HTypeUserImage hType = EnumTypeUtility.getEnumFromValue(HTypeUserImage.class, value);

        if (hType == null) {
            throw new IllegalArgumentException(value);
        }
        return hType;
    }

    private final String label;

    private final String value;
}
