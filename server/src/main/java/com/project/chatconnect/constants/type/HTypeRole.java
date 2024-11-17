package com.project.chatconnect.constants.type;

import com.project.chatconnect.utility.EnumTypeUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Role code.
 *
 * @author Huy Dang
 */
@Getter
@AllArgsConstructor
public enum HTypeRole implements EnumType {
    /**
     * Member role code.
     */
    MEMBER("Member", "1"),
    /**
     * Vice leader role code.
     */
    VICE_LEADER("Vice Leader", "2"),
    /**
     * Leader role code.
     */
    LEADER("Leader", "3"),
    /**
     * Admin role code.
     */
    ADMIN("Admin", "4");

    /**
     * Of h type role.
     *
     * @param value the value
     * @return the h type role
     */
    public static HTypeRole of(String value) {
        HTypeRole hType = EnumTypeUtility.getEnumFromValue(HTypeRole.class, value);

        if (hType == null) {
            throw new IllegalArgumentException(value);
        }
        return hType;
    }

    private final String label;

    private final String value;
}
