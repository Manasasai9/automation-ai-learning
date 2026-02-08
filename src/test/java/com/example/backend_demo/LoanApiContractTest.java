package com.example.backend_demo;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoanApiContractTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void loanSuccessContractShouldRemainStable() {

        given()
                .contentType("application/json")
                .body("""
                {
                  "customerId": "123",
                  "amount": 50000,
                  "product": "HOME"
                }
            """)
                .when()
                .post("/loan")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

    @Test
    void loanValidationErrorContractShouldRemainStable() {

        given()
                .contentType("application/json")
                .body("""
                {
                  "amount": -10,
                  "product": ""
                }
            """)
                .when()
                .post("/loan")
                .then()
                .statusCode(400)
                .body("status", equalTo(400))
                .body("message", equalTo("Validation failed"))
                .body("errors", notNullValue())
                .body("errors.size()", greaterThan(0))
                .body("timestamp", notNullValue());
    }
}
