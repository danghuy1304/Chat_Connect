package com.project.chatconnect.constants.type;

import com.project.chatconnect.utility.EnumTypeUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Emoji type.
 *
 * @author Huy Dang
 */
@Getter
@AllArgsConstructor
public enum HTypeEmoji implements EnumType {
    /**
     * Person emoji type.
     */
    PERSON("Person", "1"),
    /**
     * Animal emoji type.
     */
    ANIMAL("Animal", "2"),
    /**
     * Plant emoji type.
     */
    PLANT("Plant", "3"),
    /**
     * Food emoji type.
     */
    FOOD("Food", "4"),
    /**
     * Travel emoji type.
     */
    TRAVEL("Travel", "5"),
    /**
     * Activity emoji type.
     */
    ACTIVITY("Activity", "6"),
    /**
     * Object emoji type.
     */
    OBJECT("Object", "7"),
    /**
     * Symbol emoji type.
     */
    SYMBOL("Symbol", "8"),
    /**
     * Flag emoji type.
     */
    FLAG("Flag", "9");

    /**
     * Of h type emoji.
     *
     * @param value the value
     * @return the h type emoji
     */
    public static HTypeEmoji of(String value) {
        HTypeEmoji hType = EnumTypeUtility.getEnumFromValue(HTypeEmoji.class, value);

        if (hType == null) {
            throw new IllegalArgumentException(value);
        }
        return hType;
    }

    private final String label;

    private final String value;
}
