package com.trootech.milind.mehta.advice;

import com.trootech.milind.mehta.exception.DoctorNotFoundException;
import com.trootech.milind.mehta.exception.InvalidCaseException;
import com.trootech.milind.mehta.exception.dto.ErrorModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String ENTITY_NOT_FOUND = "Entity not found";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("handleMethodArgumentNotValid {}", ex.getStackTrace());
        ErrorModel error = new ErrorModel(HttpStatus.BAD_REQUEST, ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("handleHttpMessageNotReadable {}", ex.getStackTrace());
        ErrorModel error = new ErrorModel(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DoctorNotFoundException.class)
    private ResponseEntity<ErrorModel> handleDoctorNotFoundException(DoctorNotFoundException ex) {
        log.error("handleDoctorNotFoundException {}", ex.getStackTrace());
        ErrorModel error = new ErrorModel(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCaseException.class)
    private ResponseEntity<ErrorModel> handleInvalidCaseTimeException(InvalidCaseException ex) {
        log.error("handleInvalidCaseTimeException {}", ex.getStackTrace());
        ErrorModel error = new ErrorModel(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}