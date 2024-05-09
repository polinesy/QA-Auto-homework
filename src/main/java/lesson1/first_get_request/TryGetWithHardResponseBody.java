package lesson1.first_get_request;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TryGetWithHardResponseBody {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in/";

        Response response = RestAssured.get("/api/users?page=2");
        String responseString = response.getBody().asString();

    }
}
