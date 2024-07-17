package resttest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class resttest {

    @Test
    public void testGetRequest() {
        // Set the base URL
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send a GET request to the /posts endpoint
        Response response = given()
            .when()
            .get("/posts/1")
            .then()
            .statusCode(200)
            .body("userId", equalTo(1))
            .body("id", equalTo(1))
            .body("title", notNullValue())
            .extract()
            .response();

        // Print the response
        System.out.println("Response: " + response.asString());
    }
}