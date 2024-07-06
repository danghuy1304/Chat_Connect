package com.project.chatconnect.configs.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * The type Not found exception.
 * Author: Huy Dang
 */
@Getter
@Setter
public class NotFoundException extends RuntimeException {
    private HttpStatus status;

    private String userMessage;

    private String devMessage;

    /**
     * Instantiates a new Not found exception.
     *
     * @param devMessage the dev message
     */
    public NotFoundException(String devMessage) {
        super(devMessage);
        this.status = HttpStatus.NOT_FOUND;
        this.devMessage = devMessage;
    }

    /**
     * Instantiates a new Not found exception.
     *
     * @param userMessage the user message
     * @param devMessage  the dev message
     */
    public NotFoundException(String userMessage, String devMessage) {
        super(devMessage);
        this.status = HttpStatus.NOT_FOUND;
        this.userMessage = userMessage;
        this.devMessage = devMessage;
    }
}
