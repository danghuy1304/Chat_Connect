package com.project.chatconnect.domains.enums;

import lombok.Getter;

@Getter
public enum Gender {
    MALE("male"),
    FEMALE("female"),
    OTHER("other");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }
}
