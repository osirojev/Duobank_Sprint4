package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DatabaseStepDefs {

    @When("I send the query to get all playlists")
    public void i_send_the_query_to_get_all_playlists() {
        System.out.println("send query");
    }
    @Then("The resuld should correct")
    public void the_resuld_should_correct() {
        System.out.println("verify the result");
    }
}
