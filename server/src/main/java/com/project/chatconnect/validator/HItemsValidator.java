package com.project.chatconnect.validator;

import com.project.chatconnect.annotation.validator.HVItems;
import com.project.chatconnect.constants.type.EnumType;
import com.project.chatconnect.utility.EnumTypeUtility;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HItemsValidator implements ConstraintValidator<HVItems, Object> {

    public static final String INVALID_MESSAGE = "Vui lòng chọn.";

    private static final Logger LOGGER = LoggerFactory.getLogger(HItemsValidator.class);

    private Class<? extends EnumType> targetHType;

    private String[] targetArray;

    @Override
    public void initialize(HVItems annotation) {
        targetHType = annotation.target();
        targetArray = annotation.targetArray();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (!Objects.equals(value, null) && !Objects.equals(value, "")) {
            if (!Objects.equals(targetArray, null) && targetArray.length > 0) {
                return isValidArray(value);
            }
            if (value instanceof String && EnumTypeUtility.isExist(targetHType, (String) value)) {
                return false;
            } else if (value instanceof String[]) {
                for (String curValue : (String[]) value) {
                    if (EnumTypeUtility.isExist(targetHType, curValue)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isValidArray(Object value) {
        List<String> targetList = Arrays.asList(targetArray);
        if (value instanceof String) {
            return targetList.contains((String) value);
        } else if (value instanceof String[]) {
            for (String curValue : (String[]) value) {
                if (!targetList.contains(curValue)) {
                    return false;
                }
            }
        }
        return true;
    }
}
