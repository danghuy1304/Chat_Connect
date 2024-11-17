package com.project.chatconnect.annotation.validator;

import com.project.chatconnect.constants.type.EnumType;
import com.project.chatconnect.validator.HItemsValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The interface Hv items.
 *
 * @author Huy Dang
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = HItemsValidator.class)
public @interface HVItems {
    /**
     * Message string.
     *
     * @return the string
     */
    String message() default HItemsValidator.INVALID_MESSAGE;

    /**
     * Groups class [ ].
     *
     * @return the class [ ]
     */
    Class<?>[] groups() default {};

    /**
     * Target class [ ].
     *
     * @return the class [ ]
     */
    Class<? extends EnumType> target() default EnumType.class;

    /**
     * Target array string [ ].
     *
     * @return the string [ ]
     */
    String[] targetArray() default {};
}
