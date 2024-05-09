package lesson1.first_get_request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class TryGetRequest {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in/";
        given()
                .when()
                .get("/api/users/2")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
        Response response = RestAssured.get("/api/users/2");
        String responseString = response.getBody().asString();
        System.out.println(responseString);
    }
}
