package com.project.chatconnect.validator;

import org.springframework.stereotype.Component;

/**
 * The type Number utility.
 */
@Component
public class NumberUtility {
    /**
     * Instantiates a new Number utility.
     */
    public NumberUtility() {
    }

    /**
     * Is number boolean.
     *
     * @param value the value
     * @return the boolean
     */
    public boolean isNumber(String value) {

        if (value == null || value.length() == 0) {
            return false;
        }

        char[] chars = value.toCharArray();
        boolean hasDecPoint = false;
        boolean foundDigit = false;

        int start = 0;
        if (chars[0] == '-' || chars[0] == '+') {
            start = 1;
        }

        for (int i = start; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                foundDigit = true;

            } else if (chars[i] == '.') {
                if (hasDecPoint) {
                    return false;
                }
                hasDecPoint = true;

            } else {
                return false;
            }
        }

        return foundDigit;
    }
}
