package com.project.chatconnect.constants.type;

import com.project.chatconnect.utility.EnumTypeUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Status member.
 *
 * @author Huy Dang
 */
@Getter
@AllArgsConstructor
public enum HTypeStatusMember implements EnumType {
    /**
     * Pending status member.
     */
    PENDING("Pending", "1"),
    /**
     * Block status member.
     */
    BLOCK("Block", "2"),
    /**
     * Approved status member.
     */
    APPROVED("Approved", "3");

    public static HTypeStatusMember of(String value) {
        HTypeStatusMember hType = EnumTypeUtility.getEnumFromValue(HTypeStatusMember.class, value);

        if (hType == null) {
            throw new IllegalArgumentException(value);
        }
        return hType;
    }

    private final String label;

    private final String value;
}
