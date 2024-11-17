package com.project.chatconnect.constants.type;

import com.project.chatconnect.utility.EnumTypeUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Permission member group.
 *
 * @author Huy Dang
 */
@Getter
@AllArgsConstructor
public enum HTypePermissionMemberGroup implements EnumType {
    /**
     * Admin permission member group.
     */
    ADMIN("Admin", "1"),
    /**
     * Censor permission member group.
     */
    CENSOR("Censor", "2"),
    /**
     * Member permission member group.
     */
    MEMBER("Member", "3"),
    /**
     * Expert permission member group.
     */
    EXPERT("Expert", "4");

    public static HTypePermissionMemberGroup of(String value) {
        HTypePermissionMemberGroup hType = EnumTypeUtility.getEnumFromValue(HTypePermissionMemberGroup.class, value);

        if (hType == null) {
            throw new IllegalArgumentException(value);
        }
        return hType;
    }

    private final String label;

    private final String value;
}
