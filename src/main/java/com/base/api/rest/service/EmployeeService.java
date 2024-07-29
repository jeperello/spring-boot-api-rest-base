package com.base.api.rest.service;

import com.base.api.rest.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee createEmployee(Employee newEmployee);

    Employee getEmployee(Long id);

    Employee updateEmployee(Employee newEmployee, Long id);
    void deleteEmployee(Long id);
}
