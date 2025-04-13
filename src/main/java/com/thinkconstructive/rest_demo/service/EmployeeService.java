package com.thinkconstructive.rest_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkconstructive.rest_demo.model.Employee;
import com.thinkconstructive.rest_demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(); // Mengambil semua data employee
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null); // Mengembalikan null jika tidak ditemukan
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee); // Menyimpan data employee baru
    }

    public Employee updateEmployee(int id, Employee updatedEmployee) {
        updatedEmployee.setId(id); // Pastikan ID tetap sesuai
        return employeeRepository.save(updatedEmployee); // Menyimpan data yang sudah diperbarui
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id); // Menghapus employee berdasarkan ID
    }
}
