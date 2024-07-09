package com.project.chatconnect.domains.enums.role;

import lombok.Getter;

/**
 * The enum Role code.
 *
 * @author Huy Dang
 */
@Getter
public enum RoleCode {
    /**
     * Member role code.
     */
    MEMBER("member"),
    /**
     * Vice leader role code.
     */
    VICE_LEADER("vice_leader"),
    /**
     * Leader role code.
     */
    LEADER("leader"),
    /**
     * Admin role code.
     */
    ADMIN("admin");

    private final String roleName;

    RoleCode(String roleName) {
        this.roleName = roleName;
    }
}
