package com.example.backend_demo.service;

import com.example.backend_demo.LoanRequest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoanServiceTest {

    private final LoanService loanService = new LoanService();

    @ParameterizedTest(name = "customerId={0}, amount={1}, product={2}")
    @CsvSource({
            "123, 50000, HOME",
            "456, 100000, CAR",
            "789, 75000, PERSONAL"
    })
    void shouldProcessLoanForDifferentInputs(String customerId, double amount, String product) {

        LoanRequest request = new LoanRequest();
        request.setCustomerId(customerId);
        request.setAmount(amount);
        request.setProduct(product);

        String result = loanService.processLoan(request);

        assertTrue(result.contains(customerId));
        assertTrue(result.contains(product));
    }
}
