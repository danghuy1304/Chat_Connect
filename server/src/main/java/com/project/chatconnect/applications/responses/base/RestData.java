package com.project.chatconnect.applications.responses.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * The type Rest data.
 * Author: Huy Dang
 *
 * @param <Data> the type parameter
 */
@Setter
@Getter
public class RestData<Data> {
    private int status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userMessage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String devMessage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Data data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> userMessages;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> devMessages;

    /**
     * Instantiates a new Rest data.
     *
     * @param status      the status
     * @param userMessage the user message
     * @param devMessage  the dev message
     * @param data        the data
     */
    public RestData(HttpStatus status, String userMessage, String devMessage, Data data) {
        this.status = status.value();
        this.userMessage = userMessage;
        this.devMessage = devMessage;
        this.data = data;
    }

    /**
     * Instantiates a new Rest data.
     *
     * @param status      the status
     * @param userMessage the user message
     * @param devMessage  the dev message
     */
    public RestData(HttpStatus status, String userMessage, String devMessage) {
        this.status = status.value();
        this.userMessage = userMessage;
        this.devMessage = devMessage;
    }

    /**
     * Instantiates a new Rest data.
     *
     * @param status     the status
     * @param devMessage the dev message
     * @param data       the data
     */
    public RestData(HttpStatus status, String devMessage, Data data) {
        this.status = status.value();
        this.devMessage = devMessage;
        this.data = data;
    }

    /**
     * Instantiates a new Rest data.
     *
     * @param status       the status
     * @param userMessages the user messages
     * @param devMessages  the dev messages
     */
    public RestData(HttpStatus status, List<String> userMessages, List<String> devMessages) {
        this.status = status.value();
        this.userMessages = userMessages;
        this.devMessages = devMessages;
    }

    /**
     * Instantiates a new Rest data.
     *
     * @param status     the status
     * @param devMessage the dev message
     */
    public RestData(HttpStatus status, String devMessage) {
        this.status = status.value();
        this.devMessage = devMessage;
    }

    /**
     * Error rest data.
     *
     * @param status      the status
     * @param userMessage the user message
     * @param devMessage  the dev message
     * @return the rest data
     */
    public static RestData<?> error(HttpStatus status, String userMessage, String devMessage) {
        return new RestData<>(status, userMessage, devMessage);
    }

    /**
     * Error rest data.
     *
     * @param status     the status
     * @param devMessage the dev message
     * @return the rest data
     */
    public static RestData<?> error(HttpStatus status, String devMessage) {
        return new RestData<>(status, devMessage);
    }

    /**
     * Errors rest data.
     *
     * @param status       the status
     * @param userMessages the user messages
     * @param devMessages  the dev messages
     * @return the rest data
     */
    public static RestData<?> errors(HttpStatus status, List<String> userMessages, List<String> devMessages) {
        return new RestData<>(status, userMessages, devMessages);
    }
}
