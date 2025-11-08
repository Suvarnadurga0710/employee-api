package com.example.employee_api.controller;

import com.example.employee_api.entity.Employee;
import com.example.employee_api.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // GET all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    // GET employee by email
    @GetMapping("/email")
    public ResponseEntity<Employee> getByEmail(@RequestParam String email) {
        Employee emp = service.getEmployeeByEmail(email);
        if (emp != null) return ResponseEntity.ok(emp);
        return ResponseEntity.notFound().build();
    }

    // GET employee by name
    @GetMapping("/name")
    public List<Employee> getByName(@RequestParam String name) {
        return service.getEmployeeByName(name);
    }

    // POST create new employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee saved = service.createEmployee(employee);
        return ResponseEntity.status(201).body(saved);
    }

    // PUT update employee completely by id
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updated = service.updateEmployee(id, employee);
        if (updated != null) return ResponseEntity.ok(updated);
        return ResponseEntity.notFound().build();
    }

    // PATCH update phone only
    @PatchMapping("/{id}/phone")
    public ResponseEntity<Employee> updatePhone(@PathVariable Long id, @RequestBody Map<String, String> phoneMap) {
        String phone = phoneMap.get("phone");
        Employee updated = service.updateEmployeePhone(id, phone);
        if (updated != null) return ResponseEntity.ok(updated);
        return ResponseEntity.notFound().build();
    }

    // DELETE employee by email
    @DeleteMapping("/email")
    public ResponseEntity<Void> deleteByEmail(@RequestParam String email) {
        boolean deleted = service.deleteEmployeeByEmail(email);
        if (deleted) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}