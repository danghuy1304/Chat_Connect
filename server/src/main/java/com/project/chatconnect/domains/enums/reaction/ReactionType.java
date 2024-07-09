package com.project.chatconnect.domains.enums.reaction;

import lombok.Getter;

/**
 * The enum Reaction type.
 *
 * @author Huy Dang
 */
@Getter
public enum ReactionType {
    /**
     * Like reaction type.
     */
    LIKE("like"),

    /**
     * Love reaction type.
     */
    LOVE("love"),
    /**
     * Haha, reaction type.
     */
    HAHA("haha"),
    /**
     * Wow, reaction type.
     */
    WOW("wow"),
    /**
     * Sad reaction type.
     */
    SAD("sad"),
    /**
     * Angry reaction type.
     */
    ANGRY("angry");
    private final String reactionName;

    ReactionType(String reactionName) {
        this.reactionName = reactionName;
    }
}
