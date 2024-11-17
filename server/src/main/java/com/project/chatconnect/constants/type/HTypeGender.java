package com.project.chatconnect.constants.type;

import com.project.chatconnect.utility.EnumTypeUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Gender.
 *
 * @author Huy Dang
 */
@Getter
@AllArgsConstructor
public enum HTypeGender implements EnumType {
    /**
     * Male gender.
     */
    MALE("Male", "1"),
    /**
     * Female gender.
     */
    FEMALE("Female", "2"),
    /**
     * Other gender.
     */
    OTHER("Other", "3");

    /**
     * Of h type gender.
     *
     * @param value the value
     * @return the h type gender
     */
    public static HTypeGender of(String value) {
        HTypeGender hType = EnumTypeUtility.getEnumFromValue(HTypeGender.class, value);

        if (hType == null) {
            throw new IllegalArgumentException(value);
        }
        return hType;
    }

    private final String label;

    private final String value;
}
