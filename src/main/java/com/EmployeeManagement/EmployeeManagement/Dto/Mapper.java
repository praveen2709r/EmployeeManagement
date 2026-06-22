package com.EmployeeManagement.EmployeeManagement.Dto;

import com.EmployeeManagement.EmployeeManagement.Entity.Employee;

public class Mapper {
    public static Employee employeeRequestToEmployee(EmployeeRequest employeeRequest) {
        Employee employee=new Employee();
        employee.setDepartment(employeeRequest.getDepartment());
        employee.setName(employeeRequest.getName());
        employee.setSalary(employeeRequest.getSalary());
        return employee;
    }

    public static EmployeeResponse employeeToEmployeeResponse(Employee employee) {
        EmployeeResponse employeeResponse=new EmployeeResponse();
        employeeResponse.setDepartment(employee.getDepartment());
        employeeResponse.setName(employee.getName());
        employeeResponse.setSalary(employee.getSalary());
        employeeResponse.setId(employee.getId());
        return employeeResponse;
    }


}
