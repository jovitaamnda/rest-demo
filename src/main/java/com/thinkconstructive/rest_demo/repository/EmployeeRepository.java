package com.thinkconstructive.rest_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkconstructive.rest_demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // JpaRepository menyediakan operasi CRUD otomatis
}
