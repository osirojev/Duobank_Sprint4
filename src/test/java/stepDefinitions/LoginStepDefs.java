package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginStepDefs {



    String url = ConfigReader.getProperty("url");

    @Given("The user is on the homepage")
    public void the_user_is_on_the_homepage() {

        Driver.getDriver().get(url);

    }
    @When("The user enters the valid credentials")
    public void the_user_enters_the_valid_credentials() {

        new LoginPage().login(ConfigReader.getProperty("email"), ConfigReader.getProperty("pass"));

    }

    @Then("The user should be able to login and land on the homepage")
    public void the_user_should_be_able_to_login_and_land_on_the_homepage() {


        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/dashboard.php"));



    }




    @When("the user enters invalid credentials")

    public void the_user_enters_invalid_credentials() {
        new LoginPage().login("rana@gmail.com", "rana");
    }

    @Then("the user should not be able to login and get an error message")
    public void the_user_should_not_be_able_to_login_and_get_an_error_message() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("url")));
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Login Failed"));

    }


    @When("the user enters empty credentials")
    public void the_user_enters_empty_credentials() {
        new LoginPage().login("", "");
    }

    @Then("the user should not be able to login")
    public void the_user_should_not_be_able_to_login() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("url")));

    }

    @When("the user enters valid username and invalid password")
    public void the_user_enters_valid_username_and_invalid_password() {
        new LoginPage().login(ConfigReader.getProperty("email"), "duotech");
    }


    @When("The user enters wrong email type")
    public void theUserEntersWrongEmailType() {
        new LoginPage().login("rena123@ttt.com", "pass");

    }
    @Then("The user should not be able to login on homepage")
    public void theUserShouldNotBeAbleToLoginOnHomepage() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("url")));

    }




}
