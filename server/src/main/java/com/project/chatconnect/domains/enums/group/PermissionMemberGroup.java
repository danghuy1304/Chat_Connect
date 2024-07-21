package com.project.chatconnect.domains.enums.group;

import lombok.Getter;

/**
 * The enum Permission member group.
 *
 * @author Huy Dang
 */
@Getter
public enum PermissionMemberGroup {
    /**
     * Admin permission member group.
     */
    ADMIN("admin"),
    /**
     * Censor permission member group.
     */
    CENSOR("censor"),
    /**
     * Member permission member group.
     */
    MEMBER("member"),
    /**
     * Expert permission member group.
     */
    EXPERT("expert");

    private final String name;

    PermissionMemberGroup(String name) {
        this.name = name;
    }
}
