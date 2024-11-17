package com.project.chatconnect.annotation.validator;

import com.project.chatconnect.validator.HNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotation validate number.
 *
 * @author Huy Dang
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = HNumberValidator.class)
public @interface HVNumber {
    /**
     * Message string.
     *
     * @return the string
     */
    String message() default HNumberValidator.NOT_NUMBER_MESSAGE;

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
}
