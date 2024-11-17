package com.project.chatconnect.constants.type;

import com.project.chatconnect.utility.EnumTypeUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Language type.
 *
 * @author Huy Dang
 */
@Getter
@AllArgsConstructor
public enum HTypeLanguage implements EnumType {
    /**
     * Vietnamese language type.
     */
    VIETNAMESE("vi", "1"),
    /**
     * English language type.
     */
    ENGLISH("en", "2");
    
    /**
     * Of h type language.
     *
     * @param value the value
     * @return the h type language
     */
    public static HTypeLanguage of(String value) {
        HTypeLanguage hType = EnumTypeUtility.getEnumFromValue(HTypeLanguage.class, value);

        if (hType == null) {
            throw new IllegalArgumentException(value);
        }
        return hType;
    }

    private final String label;

    private final String value;
}
