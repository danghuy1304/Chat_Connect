package com.project.chatconnect.domains.enums.emoji;

import lombok.Getter;

/**
 * The enum Emoji type.
 *
 * @author Huy Dang
 */
@Getter
public enum EmojiType {
    /**
     * Person emoji type.
     */
    PERSON("person"),
    /**
     * Animal emoji type.
     */
    ANIMAL("animal"),
    /**
     * Plant emoji type.
     */
    PLANT("plant"),
    /**
     * Food emoji type.
     */
    FOOD("food"),
    /**
     * Travel emoji type.
     */
    TRAVEL("travel"),
    /**
     * Activity emoji type.
     */
    ACTIVITY("activity"),
    /**
     * Object emoji type.
     */
    OBJECT("object"),
    /**
     * Symbol emoji type.
     */
    SYMBOL("symbol"),
    /**
     * Flag emoji type.
     */
    FLAG("flag");

    private final String value;

    EmojiType(String value) {
        this.value = value;
    }
}
