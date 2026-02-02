package com.example.backend_demo;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoanApiTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void shouldReturn200ForValidLoanRequest() {
        String json = """
                {
                  "customerId": "123",
                  "amount": 50000,
                  "product": "HOME"
                }
                """;

        given()
                .contentType("application/json")
                .body(json)
                .when()
                .post("/loan")
                .then()
                .statusCode(200)
                .body(containsString("Loan processed"));
    }

    static Stream<String> invalidLoanRequests() {
        return Stream.of(
                "{ \"amount\": 50000, \"product\": \"HOME\" }",
                "{ \"customerId\": \"123\", \"amount\": -10, \"product\": \"HOME\" }",
                "{ \"customerId\": \"123\", \"amount\": 50000 }"
        );
    }

    @ParameterizedTest
    @MethodSource("invalidLoanRequests")
    void shouldReturn400ForInvalidLoanRequests(String jsonBody) {

        given()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .post("/loan")
                .then()
                .statusCode(400);
    }
}
