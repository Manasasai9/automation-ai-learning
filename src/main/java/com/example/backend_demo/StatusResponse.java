package com.example.backend_demo;

public class StatusResponse {

    private String service;
    private String status;

    public StatusResponse(String service, String status) {
        this.service = service;
        this.status = status;
    }

    public String getService() {
        return service;
    }

    public String getStatus() {
        return status;
    }
}
