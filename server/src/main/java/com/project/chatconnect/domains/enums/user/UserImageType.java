package com.project.chatconnect.domains.enums.user;

import lombok.Getter;

/**
 * The enum User image type.
 *
 * @author Huy Dang
 */
@Getter
public enum UserImageType {
    /**
     * Avatar user image type.
     */
    AVATAR("avatar"),
    /**
     * Cover user image type.
     */
    COVER("cover");

    private final String type;

    UserImageType(String type) {
        this.type = type;
    }
}
