package com.example.employee_api.specification;

import com.example.employee_api.entity.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {

    public static Specification<Employee> hasEmail(String email) {
        return (root, query, criteriaBuilder) -> 
            criteriaBuilder.equal(root.get("email"), email);
    }

    public static Specification<Employee> hasFirstName(String firstName) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), "%" + firstName.toLowerCase() + "%");
    }
}
