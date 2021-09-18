package stepDefinitions;

import com.google.gson.JsonObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

public class apiSignUpStepDefs {

    static {
        baseURI = "http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/api";
    }

    RequestSpecification requestSpecification;
    Response response;
    Map<String, String>map;
    RequestSpecification body;


    @Given("I add the headers {string}, {string} and {string}, {string}")
    public void iAddTheHeadersAnd(String contentType, String appJson, String accept, String appJson2) {

        requestSpecification = given().log().all().
        header("Content-Type","application/json","Accept", "application/json");
    }

    @Given("I create a valid credentials using {string}, {string}, {string} and {string}")
    public void i_create_a_valid_credentials_using_and(String first_name, String last_name, String email, String password) {

        JsonObject jo = new JsonObject();
        jo.addProperty("first_name", first_name);
        jo.addProperty("last_name", last_name);
        jo.addProperty("email", email);
        jo.addProperty("password", password);
        body = requestSpecification.body(jo);
    }


//    @When("I POST newly created user")
//    public void iPOSTNewlyCreatedUser() {
//
//
//        response = requestSpecification.when().log().all().
//        post("/login.php");
//    }

    @When("I send a POST request to {string} endpoint")
    public void iSendAPOSTRequestToEndpoint(String endpoint) {
       response = requestSpecification.when().log().all().
           post(endpoint);
    }


    @Then("I verify the status code should be {int}")
    public void iVerifyTheStatusCodeShouldBe(Integer statusCode) {
          response.then().log().all().
          statusCode(statusCode);
    }

    @Then("The success {string} should be {string}")
    public void theSuccessShouldBe(String message, String note) {

        response.then().log().all().
                body("message", is("You have successfully registered."));
    }
}