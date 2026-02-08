package com.example.backend_demo.error;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {

    private int status;
    private String message;
    private LocalDateTime timestamp;
    private List<FieldErrorDetail> errors;

    public ApiError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(int status, String message, List<FieldErrorDetail> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.timestamp = LocalDateTime.now();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public List<FieldErrorDetail> getErrors() {
        return errors;
    }
}
