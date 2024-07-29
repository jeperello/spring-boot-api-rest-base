package com.base.api.rest.controller;

import com.base.api.rest.model.Employee;
import com.base.api.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/employees")
class EmployeeController {
    @Autowired
    EmployeeService service;

    @GetMapping()
    List<Employee> all() {
        return service.getAll();
    }

    @PostMapping()
    Employee createEmployee(@RequestBody Employee newEmployee) {
        return service.createEmployee(newEmployee);
    }

    @GetMapping("/{id}")
    Employee getEmployee(@PathVariable Long id) {
        return service.getEmployee(id);
    }

    @PutMapping("/{id}")
    Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        return service.updateEmployee(employee, id);
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
    }
}