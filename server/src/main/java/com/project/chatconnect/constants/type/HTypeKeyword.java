package com.project.chatconnect.constants.type;

import com.project.chatconnect.utility.EnumTypeUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum H type keyword.
 */
@Getter
@AllArgsConstructor
public enum HTypeKeyword implements EnumType {
    /**
     * Keyword h type keyword.
     */
    KEYWORD("Keyword", "1"),
    /**
     * Hash tag h type keyword.
     */
    HASH_TAG("Hash Tag", "2");

    /**
     * Of h type keyword.
     *
     * @param value the value
     * @return the h type keyword
     */
    public static HTypeKeyword of(String value) {
        HTypeKeyword hType = EnumTypeUtility.getEnumFromValue(HTypeKeyword.class, value);

        if (hType == null) {
            throw new IllegalArgumentException(value);
        }
        return hType;
    }

    private final String label;

    private final String value;
}
