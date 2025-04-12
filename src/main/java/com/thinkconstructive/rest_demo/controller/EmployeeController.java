package com.thinkconstructive.rest_demo.controller;

import com.thinkconstructive.rest_demo.model.EmployeeResponse;
import com.thinkconstructive.rest_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<EmployeeResponse> getEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
}

