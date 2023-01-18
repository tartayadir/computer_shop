package com.yaroslav.controller.handlers;

import com.yaroslav.controller.services.exceptions.InsufficientFundsException;
import com.yaroslav.controller.services.exceptions.NoSuchComputerException;
import com.yaroslav.controller.services.exceptions.NoSuchCustomerException;
import com.yaroslav.model.error.ErrorMassageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Map<String, String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        log.error(ex.getMessage(), (Object) ex.getStackTrace());

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) ->{

            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InsufficientFundsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMassageResponse> handleNoSuchCarException(InsufficientFundsException ex) {

        log.error(ex.getMessage(), (Object) ex.getStackTrace());

        ErrorMassageResponse errorMassageResponse = new ErrorMassageResponse(ex.getMessage());
        return new ResponseEntity<>(errorMassageResponse, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NoSuchComputerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMassageResponse> handleNoSuchComputerException(NoSuchComputerException ex) {

        log.error(ex.getMessage(), (Object) ex.getStackTrace());

        ErrorMassageResponse errorMassageResponse = new ErrorMassageResponse(ex.getMessage());
        return new ResponseEntity<>(errorMassageResponse, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NoSuchCustomerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMassageResponse> handleNoSuchCustomerException(NoSuchCustomerException ex) {

        log.error(ex.getMessage(), (Object) ex.getStackTrace());

        ErrorMassageResponse errorMassageResponse = new ErrorMassageResponse(ex.getMessage());
        return new ResponseEntity<>(errorMassageResponse, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMassageResponse> handleIllegalArgumentException(IllegalArgumentException ex) {

        log.error(ex.getMessage(), (Object) ex.getStackTrace());

        ErrorMassageResponse errorMassageResponse = new ErrorMassageResponse(ex.getMessage());
        return new ResponseEntity<>(errorMassageResponse, HttpStatus.BAD_REQUEST);
    }
}
