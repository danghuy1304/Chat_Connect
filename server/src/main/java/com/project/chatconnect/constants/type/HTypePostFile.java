package com.project.chatconnect.constants.type;

import com.project.chatconnect.utility.EnumTypeUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Post file type.
 *
 * @author Huy Dang
 */
@Getter
@AllArgsConstructor
public enum HTypePostFile implements EnumType {
    /**
     * The constant IMAGE.
     */
    IMAGE("Image", "1"),
    /**
     * The constant VIDEO.
     */
    VIDEO("Video", "2"),
    /**
     * The constant AUDIO.
     */
    AUDIO("Audio", "3");

    /**
     * Of h type post file.
     *
     * @param value the value
     * @return the h type post file
     */
    public static HTypePostFile of(String value) {
        HTypePostFile hType = EnumTypeUtility.getEnumFromValue(HTypePostFile.class, value);

        if (hType == null) {
            throw new IllegalArgumentException(value);
        }
        return hType;
    }

    private final String label;

    private final String value;
}
