package com.project.chatconnect.validator;

import com.project.chatconnect.annotation.validator.HVSpecialCharacter;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * The type H special character validator.
 */
@Data
public class HSpecialCharacterValidator implements ConstraintValidator<HVSpecialCharacter, String> {

    /**
     * The constant NOT_SPECIAL_CHARACTER_MESSAGE.
     */
    public static final String NOT_SPECIAL_CHARACTER_MESSAGE = "Không được chứa kí tự đặc biệt";

    /**
     * The constant CONTROL_CHARACTER_0X80_0X9F.
     * Control characters 0x80 - 0x9F are not included in \p{Cntrl}, so define them yourself.
     */
    public static final String CONTROL_CHARACTER_0X80_0X9F = "\\x80\\x81\\x82\\x83\\x84\\x85\\x86"
            + "\\x87\\x88\\x89\\x8a\\x8b\\x8c\\x8d\\x8e\\x8f\\x90\\x91\\x92\\x93\\x94"
            + "\\x95\\x96\\x97\\x98\\x99\\x9a\\x9b\\x9c\\x9d\\x9e\\x9f";

    /**
     * The constant NO_SPECIAL_CHARACTER_REGEX.
     * \p{Cntrl}: Control characters, tabs, newlines [\x00-\x1F\x7F]
     * \p{Punct}: Half-width symbols [!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~] ※33(x21)~47(x2f),58(x3a)~64(x40),91(x5b)~96(x60),123(x7b)~126(x7e)
     */
    public static final String NO_SPECIAL_CHARACTER_REGEX =
            "[^\\p{Cntrl}\\p{Punct}" + CONTROL_CHARACTER_0X80_0X9F + "]*";

    /**
     * The constant NO_CONTROL_CHARACTER_REGEX.
     * \p{Cntrl}: Control characters, tabs, newlines [\x00-\x1F\x7F]
     */
    public static final String NO_CONTROL_CHARACTER_REGEX = "[^\\p{Cntrl}" + CONTROL_CHARACTER_0X80_0X9F + "]*";

    /**
     * The constant DENY_CHARACTERS.
     */
    protected static final String DENY_CHARACTERS = "\\x00\\x01\\x02\\x03\\x04\\x05\\x06\\x07\\x08"
            + "\\x0b\\x0c\\x0e\\x0f\\x10\\x11\\x12\\x13\\x14\\x15\\x16\\x17\\x18\\x19\\x1a\\x1b\\x1c\\x1d\\x1e\\x1f\\x7f"
            + CONTROL_CHARACTER_0X80_0X9F;

    /**
     * The constant ALLOWABLE_CHARACTERS_MAP.
     */
    protected static final Map<Character, String> ALLOWABLE_CHARACTERS_MAP;

    /**
     * The Allow punctuation.
     *
     * @see HVSpecialCharacter#allowPunctuation() HVSpecialCharacter#allowPunctuation()
     */
    protected boolean allowPunctuation;

    /**
     * The Allow symbol.
     *
     * @see HVSpecialCharacter#allowSymbol() HVSpecialCharacter#allowSymbol()
     */
    protected boolean allowSymbol;

    /**
     * The Allow characters.
     *
     * @see HVSpecialCharacter#allowCharacters() HVSpecialCharacter#allowCharacters()
     */
    protected char[] allowCharacters;

    static {

        ALLOWABLE_CHARACTERS_MAP = new LinkedHashMap<>();

        ALLOWABLE_CHARACTERS_MAP.put((char) 9, "\\x0" + Integer.toHexString(9));
        ALLOWABLE_CHARACTERS_MAP.put((char) 10, "\\x0" + Integer.toHexString(10));
        ALLOWABLE_CHARACTERS_MAP.put((char) 13, "\\x0" + Integer.toHexString(13));

        for (int i = 33; i <= 47; i++) {
            ALLOWABLE_CHARACTERS_MAP.put((char) i, "\\x" + Integer.toHexString(i));
        }

        for (int i = 58; i <= 64; i++) {
            ALLOWABLE_CHARACTERS_MAP.put((char) i, "\\x" + Integer.toHexString(i));
        }

        for (int i = 91; i <= 96; i++) {
            ALLOWABLE_CHARACTERS_MAP.put((char) i, "\\x" + Integer.toHexString(i));
        }

        for (int i = 123; i <= 126; i++) {
            ALLOWABLE_CHARACTERS_MAP.put((char) i, "\\x" + Integer.toHexString(i));
        }
    }

    @Override
    public void initialize(HVSpecialCharacter annotation) {
        allowPunctuation = annotation.allowPunctuation();
        allowSymbol = annotation.allowSymbol();
        allowCharacters = annotation.allowCharacters();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Objects.equals(value, null) || Objects.equals(value, "")) {
            return true;
        }

        return Pattern.matches(createPattern(), value);
    }

    /**
     * Create pattern string.
     *
     * @return the string
     */
    protected String createPattern() {

        if (allowPunctuation) {
            return "[^" + DENY_CHARACTERS + "]*";
        }

        if (allowSymbol) {
            return NO_CONTROL_CHARACTER_REGEX;
        }

        if (allowCharacters != null && allowCharacters.length != 0) {

            List<Character> denyCharacterList = new ArrayList<>(ALLOWABLE_CHARACTERS_MAP.keySet());
            for (Character allow : allowCharacters) {
                denyCharacterList.remove(allow);
            }

            StringBuilder customizePattern = new StringBuilder();
            customizePattern.append("[^").append(DENY_CHARACTERS);

            for (Character deny : denyCharacterList) {
                customizePattern.append(ALLOWABLE_CHARACTERS_MAP.get(deny));
            }

            customizePattern.append("]*");

            return customizePattern.toString();
        }

        return NO_SPECIAL_CHARACTER_REGEX;
    }
}
