package com.project.chatconnect.domains.enums.friend;

import lombok.Getter;

/**
 * The enum Friend status.
 *
 * @author Huy Dang
 */
@Getter
public enum FriendStatus {
    /**
     * Pending friend status.
     */
    PENDING("pending"),
    /**
     * Block friend status.
     */
    BLOCK("block"),
    /**
     * Follow friend status.
     */
    FOLLOW("follow"),
    /**
     * Unfollow friend status.
     */
    UNFOLLOW("unfollow"),
    /**
     * Friend friend status.
     */
    FRIEND("friend"),
    /**
     * Unfriend friend status.
     */
    UNFRIEND("unfriend"),
    /**
     * Priority friend status.
     */
    PRIORITY("priority");

    private final String status;

    FriendStatus(String status) {
        this.status = status;
    }
}
