package com.project.chatconnect.validator;

import com.project.chatconnect.annotation.validator.HVNumber;
import com.project.chatconnect.utility.ApplicationContextUtility;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.Data;

import java.util.Objects;

@Data
public class HNumberValidator implements ConstraintValidator<HVNumber, Object> {

    public final static String NOT_NUMBER_MESSAGE = "Phải là số hoặc chữ cái";

    public static final String MINUS_NUMBER_MESSAGE_ID = "{HNumberValidator.MINUS_NUMBER_detail}";

    private boolean minus;

    public static final boolean DEFAULT_MINUS_SIGN = false;

    @Override
    public void initialize(HVNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (Objects.equals(value, null) || Objects.equals(value, "")) {
            return true;
        }

        NumberUtility numberUtility = ApplicationContextUtility.getBean(NumberUtility.class);

        if (!numberUtility.isNumber(value.toString())) {
            return false;
        }

        // Whether negative numbers are allowed (default is not)
        if (!isMinus()) {
            // 負の数値かどうか
            if (value.toString().charAt(0) == '-') {
                // This setting is not required for manual validators to be triggered by dynamic validation.
                if (context != null) {
                    context.disableDefaultConstraintViolation();
                    context.buildConstraintViolationWithTemplate(MINUS_NUMBER_MESSAGE_ID).addConstraintViolation();
                }
                return false;
            }
        }
        return true;
    }

}

