package com.example.backend_demo.service;

import com.example.backend_demo.LoanRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanServiceTest {

    private final LoanService loanService = new LoanService();

    @Test
    void shouldProcessLoanSuccessfully() {
        LoanRequest request = new LoanRequest();
        request.setCustomerId("123");
        request.setAmount(50000);
        request.setProduct("HOME");

        String result = loanService.processLoan(request);

        assertTrue(result.contains("123"));
        assertTrue(result.contains("50000"));
        assertTrue(result.contains("HOME"));
    }
}
