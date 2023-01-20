package com.employee.demo.Service;

import com.employee.demo.Model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployee(Integer Id);

    String addEmployee(Employee employee);

    String updateEmployee(Employee employee);

    Employee deleteEmployee(Integer id);

    List<Employee> listAll();
}
