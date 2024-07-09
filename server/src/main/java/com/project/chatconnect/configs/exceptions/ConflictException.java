package com.project.chatconnect.configs.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * The type Conflict exception.
 *
 * @author Huy Dang
 */
@Getter
@Setter
public class ConflictException extends RuntimeException {
    private HttpStatus status;

    private String userMessage;

    private String devMessage;

    /**
     * Constructor has argument.
     *
     * @param devMessage the dev message
     */
    public ConflictException(String devMessage) {
        super(devMessage);
        this.status = HttpStatus.CONFLICT;
        this.devMessage = devMessage;
    }

    /**
     * Constructor has argument.
     *
     * @param userMessage the user message
     * @param devMessage  the dev message
     */
    public ConflictException(String userMessage, String devMessage) {
        super(devMessage);
        this.status = HttpStatus.CONFLICT;
        this.userMessage = userMessage;
        this.devMessage = devMessage;
    }
}
