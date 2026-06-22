package com.EmployeeManagement.EmployeeManagement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Map<String, String>> employeeNotFound(EmployeeNotFoundException exception){
        Map<String, String> errors = new HashMap<>();
        errors.put("message",exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                errors
        );
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity< Map<String, String>> handleValidationException(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(
                                error.getField(),
                                error.getDefaultMessage()
                        )
                );
        APIError response =
                new APIError(errors, "Validation failed");

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }
}
