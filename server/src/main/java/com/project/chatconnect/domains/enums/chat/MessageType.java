package com.project.chatconnect.domains.enums.chat;

import lombok.Getter;

/**
 * The enum Message type.
 *
 * @author Huy Dang
 */
@Getter
public enum MessageType {
    /**
     * Text message type.
     */
    TEXT("text"),
    /**
     * Image message type.
     */
    IMAGE("image"),
    /**
     * Video message type.
     */
    VIDEO("video"),
    /**
     * File message type.
     */
    FILE("file"),
    /**
     * Audio message type.
     */
    AUDIO("audio"),
    /**
     * Link message type.
     */
    LINK("link"),
    /**
     * Share message type.
     */
    SHARE("share");

    private final String type;

    MessageType(String type) {
        this.type = type;
    }
}
