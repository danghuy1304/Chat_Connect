package com.project.chatconnect.configs.exceptions;

import com.amazonaws.services.neptunedata.model.ConstraintViolationException;
import com.project.chatconnect.applications.responses.base.RestData;
import com.project.chatconnect.applications.responses.base.RestResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

/**
 * The type Rest exception handler.
 *
 * @author Huy Dang
 */
@RestControllerAdvice
@Log4j2
public class RestExceptionHandler {

    /**
     * Handle not found exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<RestData<?>> handleNotFoundException(NotFoundException e) {
        log.error("NotFoundException: ", e);
        return RestResponse.error(e.getStatus(), e.getUserMessage(), e.getDevMessage());
    }

    /**
     * Handle conflict exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<RestData<?>> handleConflictException(ConflictException e) {
        log.error("ConflictException: ", e);
        return RestResponse.error(e.getStatus(), e.getUserMessage(), e.getDevMessage());
    }

    /**
     * Handle valid input exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestData<?>> handleValidInputException(ConstraintViolationException e) {
        log.error("ConstraintViolationException: ", e);
        return RestResponse.error(HttpStatus.BAD_REQUEST, e.getMessage(), e.getMessage());
    }

    /**
     * Handle bind exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestData<?>> handleBindException(BindException e) {
        List<String> errorMessages = e.getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();
        log.error("BindException: ", e);
        return RestResponse.errors(HttpStatus.BAD_REQUEST, errorMessages);
    }

    /**
     * Handle http client error exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<RestData<?>> handleHttpClientErrorException(HttpClientErrorException e) {
        log.error("HttpClientErrorException: ", e);
        return RestResponse.error(HttpStatus.FORBIDDEN, e.getMessage(), e.getMessage());
    }

    /**
     * Handle access denied security exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<RestData<?>> handleAccessDeniedSecurityException(AccessDeniedException e) {
        log.error("AccessDeniedException: ", e);
        return RestResponse.error(HttpStatus.FORBIDDEN,
                "Bạn không có quyền truy cập vào chức năng này",
                e.getMessage());
    }

    /**
     * Handle runtime exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<RestData<?>> handleRuntimeException(RuntimeException e) {
        log.error("RuntimeException: ", e);
        return RestResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, "Đã có lỗi xảy ra!", e.getMessage());
    }
}
