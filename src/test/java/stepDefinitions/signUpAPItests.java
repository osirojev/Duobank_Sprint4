package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.Users;
import utilities.DBUtility;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class signUpAPItests {
    Users users = new Users();
    Map<String, String> map;
    RequestSpecification requestSpecification;
    Response response;

    @Given("I add payload")
    public void i_add_payload(List<Map<String,String>> dataTable) {
        map = dataTable.get(0);
        String requestBody = "{\n" +
                "   \"first_name\": \"" + map.get("firstName") + "\",\n" +
                "   \"last_name\":\"" + map.get("lastName") + "\",\n" +
                "   \"email\": \"" + map.get("email") + "\",\n" +
                "   \"password\":\"" + map.get("password") + "\"\n" +
                "}";
        requestSpecification = given()
                .body(requestBody);

    }
    @When("I send POST request to {string} endpoint")
    public void i_send_post_request_to_endpoint(String endpoint) {
        response = requestSpecification.when().log().all().post(endpoint);
    }
    @Then("The response status should be {int}")
    public void the_response_status_should_be(int code) throws SQLException {
        response.then().log().all().
                statusCode(code);

        DBUtility.updateQuery("delete from tbl_user where email='" + map.get("email") + "'");
    }

    @Then("The response is succeeded")
    public void the_response_is_succeeded() throws SQLException {
        response.then().
                body("success", equalTo(1));
    }

    @Given("I use pojo to create new User")
    public void iUsePojoToCreateNewUser() {
        users.setFirstName("Ruu");
        users.setLastName("Roo");
        users.setEmail("Ruro@gmail.com");
        users.setPassword("ruro2021");

        requestSpecification = given().body(users);
    }

    @Then("The response POJO is succeeded")
    public void theResponsePOJOIsSucceeded() throws SQLException {
        response.then().
                body("success", equalTo(1));
        DBUtility.updateQuery("delete from tbl_user where email='"+users.getEmail()+"'");
    }

    @Then("The POJO response status should be {int}")
    public void pojo_the_response_status_should_be(int code) throws SQLException {
        response.then().log().all().
                statusCode(code);

        DBUtility.updateQuery("delete from tbl_user where email='" + users.getEmail() + "'");
    }

//    @Given("I add the following payload as {string} for first name, {string} for last name, {string} for email, and {string} for password")
//    public void iAddTheFollowingPayloadAsForFirstNameForLastNameForEmailAndForPassword(String string, String string2, String string3, String string4) {
//
//    }
//    @Then("The response should not be succeeded")
//    public void theResponseShouldNotBeSucceeded() {
//
//    }

}
