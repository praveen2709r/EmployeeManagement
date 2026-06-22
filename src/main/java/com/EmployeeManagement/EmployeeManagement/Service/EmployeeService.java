package com.EmployeeManagement.EmployeeManagement.Service;

import com.EmployeeManagement.EmployeeManagement.Dto.EmployeeRequest;
import com.EmployeeManagement.EmployeeManagement.Dto.EmployeeResponse;
import com.EmployeeManagement.EmployeeManagement.Entity.Employee;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface EmployeeService {
     EmployeeResponse save(EmployeeRequest employeeRequest);
     List<EmployeeResponse> findAll();
     EmployeeResponse findById(Long id);
     EmployeeResponse updateById(Long id, EmployeeRequest employeeRequest);
}
