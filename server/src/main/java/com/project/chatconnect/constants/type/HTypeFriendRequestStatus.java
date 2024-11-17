package com.project.chatconnect.constants.type;

import com.project.chatconnect.utility.EnumTypeUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Friend request status.
 *
 * @author Huy Dang
 */
@Getter
@AllArgsConstructor
public enum HTypeFriendRequestStatus implements EnumType {
    /**
     * Pending friend request status.
     */
    PENDING("Pending", "1"),
    /**
     * Accepted friend request status.
     */
    ACCEPTED("Accepted", "2"),
    /**
     * Rejected friend request status.
     */
    REJECTED("Rejected", "3");

    /**
     * Of h type emoji.
     *
     * @param value the value
     * @return the h type emoji
     */
    public static HTypeFriendRequestStatus of(String value) {
        HTypeFriendRequestStatus hType = EnumTypeUtility.getEnumFromValue(HTypeFriendRequestStatus.class, value);

        if (hType == null) {
            throw new IllegalArgumentException(value);
        }
        return hType;
    }

    private final String label;

    private final String value;
}
