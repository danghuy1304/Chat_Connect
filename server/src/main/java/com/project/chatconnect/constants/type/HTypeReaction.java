package com.project.chatconnect.constants.type;

import com.project.chatconnect.utility.EnumTypeUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Reaction type.
 *
 * @author Huy Dang
 */
@Getter
@AllArgsConstructor
public enum HTypeReaction implements EnumType {
    /**
     * Like reaction type.
     */
    LIKE("Like", "1"),

    /**
     * Love reaction type.
     */
    LOVE("Love", "2"),
    /**
     * Haha, reaction type.
     */
    HAHA("Haha", "3"),
    /**
     * Wow, reaction type.
     */
    WOW("Wow", "4"),
    /**
     * Sad reaction type.
     */
    SAD("Sad", "4"),
    /**
     * Angry reaction type.
     */
    ANGRY("Angry", "5");

    /**
     * Of h type reaction.
     *
     * @param value the value
     * @return the h type reaction
     */
    public static HTypeReaction of(String value) {
        HTypeReaction hType = EnumTypeUtility.getEnumFromValue(HTypeReaction.class, value);

        if (hType == null) {
            throw new IllegalArgumentException(value);
        }
        return hType;
    }

    private final String label;

    private final String value;
}
