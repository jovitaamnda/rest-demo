package com.thinkconstructive.rest_demo.model;

import java.util.List;

public class EmployeeResponse {
    private String status;
    private List<Employee> data;

    // Getters dan Setters

    public static class Employee {
        private int id;
        private String employee_name;
        private int employee_salary;
        private int employee_age;

        // Getters dan Setters
    }
}
