package com.example.backend_demo.service;

import com.example.backend_demo.LoanRequest;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    public String processLoan(LoanRequest request) {

        return "Loan processed for customer "
                + request.getCustomerId()
                + " with amount "
                + request.getAmount()
                + " and product "
                + request.getProduct();
    }
}
