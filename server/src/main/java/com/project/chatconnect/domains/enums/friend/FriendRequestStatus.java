package com.project.chatconnect.domains.enums.friend;

import lombok.Getter;

/**
 * The enum Friend request status.
 *
 * @author Huy Dang
 */
@Getter
public enum FriendRequestStatus {
    /**
     * Pending friend request status.
     */
    PENDING("PENDING"),
    /**
     * Accepted friend request status.
     */
    ACCEPTED("ACCEPTED"),
    /**
     * Rejected friend request status.
     */
    REJECTED("REJECTED");

    private final String status;

    FriendRequestStatus(String status) {
        this.status = status;
    }
}
