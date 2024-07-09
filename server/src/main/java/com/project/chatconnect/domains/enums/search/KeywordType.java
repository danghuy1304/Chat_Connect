package com.project.chatconnect.domains.enums.search;

import lombok.Getter;

@Getter
public enum KeywordType {
    KEYWORD("keyword"),
    HASH_TAG("hash_tag");

    private final String type;

    KeywordType(String type) {
        this.type = type;
    }
}
