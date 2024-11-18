package com.project.chatconnect.annotation.validator;

import com.project.chatconnect.validator.HSpecialCharacterValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The interface Hv special character.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = HSpecialCharacterValidator.class)
public @interface HVSpecialCharacter {
    /**
     * Message string.
     *
     * @return the string
     */
    String message() default HSpecialCharacterValidator.NOT_SPECIAL_CHARACTER_MESSAGE;

    /**
     * Groups class [ ].
     *
     * @return the class [ ]
     */
    Class<?>[] groups() default {};

    /**
     * Payload class [ ].
     *
     * @return the class [ ]
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * Allow punctuation boolean.
     *
     * @return the boolean
     */
    boolean allowPunctuation() default false;

    /**
     * Allow symbol boolean.
     *
     * @return the boolean
     */
    boolean allowSymbol() default false;

    /**
     * Allow characters char [ ].
     *
     * @return the char [ ]
     */
    char[] allowCharacters() default {};
}
