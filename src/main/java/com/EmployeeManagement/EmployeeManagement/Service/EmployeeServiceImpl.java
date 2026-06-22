package com.EmployeeManagement.EmployeeManagement.Service;

import com.EmployeeManagement.EmployeeManagement.Dto.EmployeeRequest;
import com.EmployeeManagement.EmployeeManagement.Dto.EmployeeResponse;
import com.EmployeeManagement.EmployeeManagement.Dto.Mapper;
import com.EmployeeManagement.EmployeeManagement.Entity.Employee;
import com.EmployeeManagement.EmployeeManagement.Exception.EmployeeNotFoundException;
import com.EmployeeManagement.EmployeeManagement.Repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponse save(EmployeeRequest employeeRequest) {
        log.info("Saving employee: {}", employeeRequest.getName());

        Employee employee=Mapper.employeeRequestToEmployee(employeeRequest);
        employeeRepository.save(employee);
        log.info("Employee saved successfully with id: {}", employee.getId());
        return Mapper.employeeToEmployeeResponse(employee);
    }

    @Override
    public List<EmployeeResponse> findAll() {
        log.info("All Employees returned successfully");
        return employeeRepository.findAll().stream().map(Mapper::employeeToEmployeeResponse).toList();
    }

    @Override
    public EmployeeResponse findById(Long id) {
        log.info("Fetching employee: {}", id);

        Employee employee=employeeRepository.findById(id).orElseThrow(
                ()->new EmployeeNotFoundException("Employee not found")
        );
        log.info("Employee returned successfully with id: {}", employee.getId());

        return Mapper.employeeToEmployeeResponse(employee);
    }

    @Override
    public EmployeeResponse updateById(Long id, EmployeeRequest employeeRequest) {
        Employee employee=employeeRepository.findById(id).orElseThrow(
                ()->new EmployeeNotFoundException("Employee not found")
        );
        employee.setName(employee.getName());
        employee.setDepartment(employeeRequest.getDepartment());
        employee.setSalary(employeeRequest.getSalary());
        employeeRepository.save(employee);
        return Mapper.employeeToEmployeeResponse(employee);
    }
}
