package com.project.chatconnect.constants.type;

import com.project.chatconnect.utility.EnumTypeUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Friend status.
 *
 * @author Huy Dang
 */
@Getter
@AllArgsConstructor
public enum HTypeFriendStatus implements EnumType {
    /**
     * Pending friend status.
     */
    PENDING("Pending", "1"),
    /**
     * Block friend status.
     */
    BLOCK("Block", "2"),
    /**
     * Follow friend status.
     */
    FOLLOW("Follow", "3"),
    /**
     * Unfollow friend status.
     */
    UNFOLLOW("Unfollow", "4"),
    /**
     * Friend friend status.
     */
    FRIEND("Friend", "5"),
    /**
     * Unfriend friend status.
     */
    UNFRIEND("Unfriend", "6"),
    /**
     * Priority friend status.
     */
    PRIORITY("Priority", "7");

    /**
     * Of h type friend status.
     *
     * @param value the value
     * @return the h type friend status
     */
    public static HTypeFriendStatus of(String value) {
        HTypeFriendStatus hType = EnumTypeUtility.getEnumFromValue(HTypeFriendStatus.class, value);

        if (hType == null) {
            throw new IllegalArgumentException(value);
        }
        return hType;
    }

    private final String label;

    private final String value;
}
