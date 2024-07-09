package com.project.chatconnect.applications.responses.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * The type Rest response.
 *
 * @author Huy Dang
 */
public class RestResponse {
    /**
     * Ok response entity.
     *
     * @param data the data
     * @return the response entity
     */
    public static ResponseEntity<RestData<?>> ok(Object data) {
        return ok(HttpStatus.OK, data);
    }

    /**
     * Ok response entity.
     *
     * @param status the status
     * @param data   the data
     * @return the response entity
     */
    public static ResponseEntity<RestData<?>> ok(HttpStatus status, Object data) {
        return ok(status, data);
    }

    /**
     * Error response entity.
     *
     * @param status      the status
     * @param userMessage the user message
     * @param devMessage  the dev message
     * @return the response entity
     */
    public static ResponseEntity<RestData<?>> error(HttpStatus status, String userMessage, String devMessage) {
        RestData<?> restData = RestData.error(status, userMessage, devMessage);
        return new ResponseEntity<>(restData, status);
    }

    /**
     * Error response entity.
     *
     * @param status     the status
     * @param devMessage the dev message
     * @return the response entity
     */
    public static ResponseEntity<RestData<?>> error(HttpStatus status, String devMessage) {
        RestData<?> restData = RestData.error(status, devMessage);
        return new ResponseEntity<>(restData, status);
    }

    /**
     * Errors response entity.
     *
     * @param status        the status
     * @param errorMessages the error messages
     * @return the response entity
     */
    public static ResponseEntity<RestData<?>> errors(HttpStatus status, List<String> errorMessages) {
        RestData<?> restData = RestData.errors(status, errorMessages, errorMessages);
        return new ResponseEntity<>(restData, status);
    }
}
