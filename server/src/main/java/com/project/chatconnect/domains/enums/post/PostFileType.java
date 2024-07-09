package com.project.chatconnect.domains.enums.post;

import lombok.Getter;

/**
 * The enum Post file type.
 *
 * @author Huy Dang
 */
@Getter
public enum PostFileType {
    /**
     * The constant IMAGE.
     */
    IMAGE("image"),
    /**
     * The constant VIDEO.
     */
    VIDEO("video"),
    /**
     * The constant AUDIO.
     */
    AUDIO("audio");
    private final String fileType;

    PostFileType(String fileType) {
        this.fileType = fileType;
    }
}
