package com.project.chatconnect.domains.enums.user;

import lombok.Getter;

/**
 * The enum Gender.
 * Author: Huy Dang
 */
@Getter
public enum Gender {
    /**
     * Male gender.
     */
    MALE("male"),
    /**
     * Female gender.
     */
    FEMALE("female"),
    /**
     * Other gender.
     */
    OTHER("other");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }
}
