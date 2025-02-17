package com.kurtneyjantjies.real_estate_data_integration.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles validation errors globally across all controllers.
     */
    @ExceptionHandler(org.springframework.validation.BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleValidationExceptions(org.springframework.validation.BindException ex) {
        StringBuilder errorMessages = new StringBuilder();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            errorMessages.append(error.getDefaultMessage()).append("; ");
        }
        return ResponseEntity.badRequest().body(errorMessages.toString());
    }

    /**
     * Handles all other exceptions and returns a 500 Internal Server Error response.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleOtherExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Internal Server Error: " + ex.getMessage());
    }
}
