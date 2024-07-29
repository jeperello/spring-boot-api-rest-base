package com.base.api.rest.serviceImpl;

import com.base.api.rest.exception.EmployeeNotFoundException;
import com.base.api.rest.model.Employee;
import com.base.api.rest.repository.EmployeeRepository;
import com.base.api.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository repository;

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Employee createEmployee(Employee newEmployee) {
        return repository.save(newEmployee);
    }

    @Override
    public Employee getEmployee(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public Employee updateEmployee(Employee newEmployee, Long id) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRoles(newEmployee.getRoles());
                    return repository.save(employee);
                })
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}