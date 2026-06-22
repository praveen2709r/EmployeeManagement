package com.EmployeeManagement.EmployeeManagement.Controller;

import com.EmployeeManagement.EmployeeManagement.Dto.EmployeeRequest;
import com.EmployeeManagement.EmployeeManagement.Dto.EmployeeResponse;
import com.EmployeeManagement.EmployeeManagement.Entity.Employee;
import com.EmployeeManagement.EmployeeManagement.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    public ResponseEntity<EmployeeResponse> save(@RequestBody @Valid EmployeeRequest employeeRequest){

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employeeRequest));
    }
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(
                employeeService.findById(id)
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateById(@PathVariable Long id,@RequestBody EmployeeRequest employeeRequest){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateById(id,employeeRequest));
    }

}
