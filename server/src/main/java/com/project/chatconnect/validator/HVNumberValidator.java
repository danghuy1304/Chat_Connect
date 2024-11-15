package com.project.chatconnect.validator;

import com.project.chatconnect.annotation.validator.HVNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class HVNumberValidator implements ConstraintValidator<HVNumber, Object> {

    public final static String NOT_NUMBER_MESSAGE = "Phải là số hoặc chữ cái";

    @Override
    public void initialize(HVNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return false;
    }
}

