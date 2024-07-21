package com.project.chatconnect.domains.enums.group;

import lombok.Getter;

/**
 * The enum Status member.
 *
 * @author Huy Dang
 */
@Getter
public enum StatusMember {
    /**
     * Pending status member.
     */
    PENDING("pending"),
    /**
     * Block status member.
     */
    BLOCK("block"),
    /**
     * Approved status member.
     */
    APPROVED("approved");

    private final String status;

    StatusMember(String status) {
        this.status = status;
    }
}
