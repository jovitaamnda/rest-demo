package com.thinkconstructive.rest_demo.model;

import java.util.List;

public class EmployeeResponse {
    private String status;
    private List<EmployeeData> data;

    // Getters dan Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<EmployeeData> getData() {
        return data;
    }

    public void setData(List<EmployeeData> data) {
        this.data = data;
    }
}
