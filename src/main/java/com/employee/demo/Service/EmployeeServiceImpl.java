package com.employee.demo.Service;


import com.employee.demo.Exception.EmployeeAlreadyExistsException;
import com.employee.demo.Model.Employee;
import com.employee.demo.Repository.EmployeeRepo;
import com.employee.demo.Exception.NoSuchEmployeeExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> listAll() {
        return employeeRepo.findAll();
    }

    public Employee getEmployee(Integer Id) {
        return employeeRepo.findById(Id).orElseThrow(
                ()
                        -> new NoSuchElementException(
                        "NO CUSTOMER PRESENT WITH ID = " + Id));
    }

    public String addEmployee(Employee employee) {
        Employee existingEmployee
                = employeeRepo.findById(employee.getId())
                .orElse(null);
        if (existingEmployee == null) {
            employeeRepo.save(employee);
            return "Employee added successfully";
        } else
            throw new EmployeeAlreadyExistsException(
                    "Employee already exists!!");
    }

    public String updateEmployee(Employee employee) {
        Employee existingEmployee
                = employeeRepo.findById(employee.getId())
                .orElse(null);
        if (existingEmployee == null)
            throw new NoSuchEmployeeExistsException(
                    "No Such Employee exists!!");
        else {
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(
                    employee.getLastName());
            existingEmployee.setCity(employee.getCity());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setPhone(employee.getPhone());
            employeeRepo.save(existingEmployee);
            return "Record updated Successfully";
        }
    }

    public Employee deleteEmployee(Integer Id) {
        if (employeeRepo.existsById(Id)) {
            employeeRepo.deleteById(Id);
        } else {
            throw new NoSuchEmployeeExistsException("No Such Employee exists!!");
        }
        return null;
    }
}
