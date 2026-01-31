package com.example.backend_demo;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
    public class HelloController {

        @GetMapping("/hello")
        public String sayHello() {
            return "Hello from Day 3!";
        }
        @GetMapping("/status")
        public StatusResponse getStatus() {
            return new StatusResponse("backend-demo", "UP");
        }
        @GetMapping("/loan")
        public String createLoan(
                @RequestParam String customerId,
                @RequestParam double amount) {

            return "Loan request received for customer "
                    + customerId + " with amount " + amount;
        }
        @PostMapping("/loan")
        public String createLoanPost( @Valid @RequestBody LoanRequest loanRequest) {

            return "Loan request received for customer "
                    + loanRequest.getCustomerId()
                    + ", amount " + loanRequest.getAmount()
                    + ", product " + loanRequest.getProduct();
        }

    }

