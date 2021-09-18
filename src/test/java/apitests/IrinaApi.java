package apitests;

import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class IrinaApi {

    @Test
    public void signupPositive() {

        String requestBody = "{\n" +
                "   \"first_name\": \"Lolo\",\n" +
                "   \"last_name\": \"Pepe\",\n" +
                "   \"email\": \"lolopepe2021@gmail.com\",\n" +
                "   \"password\": \"duotech2021\"\n" +
                "}";

        Map map = given()
                .header("Accept", "application/json")
                .and()
                .body(requestBody)
                .post("/register.php")
                .then().log().all().
                        statusCode(200).extract().as(Map.class);
    }

}
