package com.EmployeeManagement.EmployeeManagement.Exception;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIError {
    private Map<String, String> errors;

    private String message;
}
