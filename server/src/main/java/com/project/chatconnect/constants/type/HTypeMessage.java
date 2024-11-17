package com.project.chatconnect.constants.type;

import com.project.chatconnect.utility.EnumTypeUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Message type.
 *
 * @author Huy Dang
 */
@Getter
@AllArgsConstructor
public enum HTypeMessage implements EnumType {
    /**
     * Text message type.
     */
    TEXT("Text", "1"),
    /**
     * Image message type.
     */
    IMAGE("Image", "2"),
    /**
     * Video message type.
     */
    VIDEO("Video", "3"),
    /**
     * File message type.
     */
    FILE("File", "4"),
    /**
     * Audio message type.
     */
    AUDIO("Audio", "5"),
    /**
     * Link message type.
     */
    LINK("Link", "6"),
    /**
     * Share message type.
     */
    SHARE("Share", "7");
    
    /**
     * Of h type message.
     *
     * @param value the value
     * @return the h type message
     */
    public static HTypeMessage of(String value) {
        HTypeMessage hType = EnumTypeUtility.getEnumFromValue(HTypeMessage.class, value);

        if (hType == null) {
            throw new IllegalArgumentException(value);
        }
        return hType;
    }

    private final String label;

    private final String value;
}
