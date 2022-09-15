package com.geekbrains;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.jupiter.api.BeforeAll;
import static org.hamcrest.Matchers.lessThan;

public class Base {

    private static final String API_KEY = "4782ca94f53b48f691a56323358382b8";
    private static final String BASE_URL = "https://api.spoonacular.com";



    @BeforeAll
    static void beforeALL() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", API_KEY)
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThan(3000L))
                .build();
    }
}