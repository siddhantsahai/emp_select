package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private int nextId = 1;

    public List<Employee> findAll() {
        return new ArrayList<>(employees);
    }

    public Optional<Employee> findById(int id) {
        return employees.stream().filter(employee -> employee.getId() == id).findFirst();
    }

    public Employee create(Employee employee) {
        employee.setId(nextId++);
        employees.add(employee);
        return employee;
    }

    public Optional<Employee> update(int id, Employee updatedEmployee) {
        return findById(id).map(existingEmployee -> {
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setDepartment(updatedEmployee.getDepartment());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            return existingEmployee;
        });
    }

    public boolean delete(int id) {
        return employees.removeIf(employee -> employee.getId() == id);
    }
}
