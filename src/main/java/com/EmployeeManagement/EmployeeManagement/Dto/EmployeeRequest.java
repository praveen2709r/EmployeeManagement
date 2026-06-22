package com.EmployeeManagement.EmployeeManagement.Dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Name must contain at least 3 characters")
    private String name;
    @NotBlank(message = "Department is required")
    @Size(min = 2, message = "")
    private String department;
    @Min(value = 1, message = "Salary must be greater than 0")
    @Max(value = 1000000, message = "Salary cannot exceed 1000000")
    private BigDecimal salary;
}
