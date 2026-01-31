package com.example.backend_demo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class LoanRequest {
    @NotBlank
    private String customerId;
    @Positive
    private double amount;
    @NotBlank
    private String product;

    public LoanRequest() {
        // default constructor required for JSON mapping
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
