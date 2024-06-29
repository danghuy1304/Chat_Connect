package com.project.chatconnect.domains.enums;

import lombok.Getter;

@Getter
public enum RoleCode {
    MEMBER("member"),
    VICE_LEADER("vice_leader"),
    LEADER("leader"),
    ADMIN("admin");

    private final String roleName;

    RoleCode(String roleName) {
        this.roleName = roleName;
    }
}
