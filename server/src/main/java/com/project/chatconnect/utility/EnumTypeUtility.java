package com.project.chatconnect.utility;

import com.project.chatconnect.constants.type.EnumType;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The type Enum type utility.
 *
 * @author Huy Dang
 */
public class EnumTypeUtility {

    private EnumTypeUtility() {
    }

    /**
     * Gets enum map.
     *
     * @param <T>           the type parameter
     * @param enumTypeClass the enum type class
     * @return the enum map
     */
    public static <T extends EnumType> Map<String, String> getEnumMap(Class<T> enumTypeClass) {

        return getEnumMap(enumTypeClass, false);
    }

    /**
     * Gets enum map.
     *
     * @param <T>           the type parameter
     * @param enumTypeClass the enum type class
     * @param labelKeyFlag  the label key flag
     * @return the enum map
     */
    public static <T extends EnumType> Map<String, String> getEnumMap(Class<T> enumTypeClass, boolean labelKeyFlag) {
        Map<String, String> enumMap = new LinkedHashMap<>();
        EnumType[] enumTypeArray = enumTypeClass.getEnumConstants();

        if (enumTypeArray == null) {
            return null;
        }
        for (EnumType h : enumTypeArray) {
            if (labelKeyFlag) {
                enumMap.put(h.getLabel(), h.getLabel());
            } else {
                enumMap.put(h.getValue(), h.getLabel());
            }
        }
        return enumMap;
    }


    /**
     * Gets enum from value.
     *
     * @param <T>           the type parameter
     * @param enumTypeClass the enum type class
     * @param value         the value
     * @return the enum from value
     */
    public static <T extends EnumType> T getEnumFromValue(Class<T> enumTypeClass, String value) {

        T[] enumTypeArray = enumTypeClass.getEnumConstants();

        if (enumTypeArray == null) {
            return null;
        }

        for (T enumType : enumTypeArray) {
            if (enumType.getValue().equals(value)) {
                return enumType;
            }
        }

        return null;
    }

    /**
     * Is exist boolean.
     *
     * @param <T>           the type parameter
     * @param enumTypeClass the enum type class
     * @param value         the value
     * @return the boolean
     */
    public static <T extends EnumType> boolean isExist(Class<T> enumTypeClass, String value) {

        return getEnumFromValue(enumTypeClass, value) == null;
    }

    /**
     * Gets enum from label.
     *
     * @param <T>           the type parameter
     * @param enumTypeClass the enum type class
     * @param label         the label
     * @return the enum from label
     */
    public static <T extends EnumType> T getEnumFromLabel(Class<T> enumTypeClass, String label) {
        T[] enumTypeArray = enumTypeClass.getEnumConstants();

        if (enumTypeArray == null) {
            return null;
        }

        for (T enumType : enumTypeArray) {
            if (enumType.getLabel().equals(label)) {
                return enumType;
            }
        }
        return null;
    }

    /**
     * Gets label value.
     *
     * @param enumType the enum type
     * @return the label value
     */
    public static String getLabelValue(EnumType enumType) {

        if (enumType == null) {
            return null;
        }
        return enumType.getLabel();
    }

    /**
     * Gets value.
     *
     * @param enumType the enum type
     * @return the value
     */
    public static String getValue(EnumType enumType) {

        if (enumType == null) {
            return null;
        }
        return enumType.getValue();
    }
}
