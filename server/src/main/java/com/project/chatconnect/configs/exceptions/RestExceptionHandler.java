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

@RestControllerAdvice
@Log4j2
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<RestData<?>> handleNotFoundException(NotFoundException e) {
        log.error("NotFoundException: {0}", e);
        return RestResponse.error(e.getStatus(), e.getUserMessage(), e.getDevMessage());
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<RestData<?>> handleConflictException(ConflictException e) {
        log.error("ConflictException: {0}", e);
        return RestResponse.error(e.getStatus(), e.getUserMessage(), e.getDevMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestData<?>> handleValidInputException(ConstraintViolationException e) {
        log.error("ConstraintViolationException: {0}", e);
        return RestResponse.error(HttpStatus.BAD_REQUEST, e.getMessage(), e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestData<?>> handleBindException(BindException e) {
        List<String> errorMessages = e.getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();
        log.error("BindException: {0}", e);
        return RestResponse.errors(HttpStatus.BAD_REQUEST, errorMessages);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<RestData<?>> handleHttpClientErrorException(HttpClientErrorException e) {
        log.error("HttpClientErrorException: {0}", e);
        return RestResponse.error(HttpStatus.FORBIDDEN, e.getMessage(), e.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<RestData<?>> handleAccessDeniedSecurityException(AccessDeniedException e) {
        log.error("AccessDeniedException: {0}", e);
        return RestResponse.error(HttpStatus.FORBIDDEN,
                "Bạn không có quyền truy cập vào chức năng này",
                e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<RestData<?>> handleRuntimeException(RuntimeException e) {
        log.error("RuntimeException: {0}", e);
        return RestResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, "Đã có lỗi xảy ra!", e.getMessage());
    }
}
