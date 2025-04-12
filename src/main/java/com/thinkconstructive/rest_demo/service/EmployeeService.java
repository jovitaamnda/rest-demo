package com.thinkconstructive.rest_demo.service;

import com.thinkconstructive.rest_demo.model.EmployeeResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {

    private final String URL = "https://dummy.restapiexample.com/api/v1/employees";

    public EmployeeResponse getAllEmployees() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(URL, EmployeeResponse.class);
    }
}
