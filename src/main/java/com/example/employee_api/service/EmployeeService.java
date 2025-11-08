package com.example.employee_api.service;

import com.example.employee_api.entity.Employee;
import com.example.employee_api.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // Fetch all employees
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // Fetch by email
    public Employee getEmployeeByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }

    // Fetch by name (partial match)
    public List<Employee> getEmployeeByName(String name) {
        return repository.findByFirstNameContainingIgnoreCase(name);
    }

    // Create new employee
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    // Update employee details (full update)
    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> existing = repository.findById(id);
        if (existing.isPresent()) {
            Employee emp = existing.get();
            emp.setFirstName(employee.getFirstName());
            emp.setLastName(employee.getLastName());
            emp.setPhone(employee.getPhone());
            emp.setAddress(employee.getAddress());
            return repository.save(emp);
        }
        return null;
    }

    // Update only phone
    public Employee updateEmployeePhone(Long id, String phone) {
        Optional<Employee> existing = repository.findById(id);
        if (existing.isPresent()) {
            Employee emp = existing.get();
            emp.setPhone(phone);
            return repository.save(emp);
        }
        return null;
    }

    // Delete by email
    public boolean deleteEmployeeByEmail(String email) {
        Optional<Employee> existing = repository.findByEmail(email);
        if (existing.isPresent()) {
            repository.delete(existing.get());
            return true;
        }
        return false;
    }
}
