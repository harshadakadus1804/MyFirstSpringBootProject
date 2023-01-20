package com.employee.demo.Controller;

import com.employee.demo.Model.Employee;
import com.employee.demo.Exception.EmployeeAlreadyExistsException;
import com.employee.demo.Exception.ErrorResponse;
import com.employee.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @ExceptionHandler(value
            = EmployeeAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse
    handleCustomerAlreadyExistsException(
            EmployeeAlreadyExistsException ex) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(),
                ex.getMessage());
    }

    @GetMapping("api/v1/employee")
    public List<Employee> list() {
        return employeeService.listAll();
    }

    @GetMapping("api/v1/employee/{Id}")
    public Employee getEmployee(@PathVariable("Id") Integer Id) {
        return employeeService.getEmployee(Id);
    }

    @PostMapping("api/v1/employee")
    public String addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("api/v1/employee/{Id}")
    public String updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("api/v1/employee/{Id}")
    public Employee deleteEmployee(@PathVariable("Id") Integer Id) {
        return employeeService.deleteEmployee(Id);

    }

}
