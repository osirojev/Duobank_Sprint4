package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginStepDefs {

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        System.out.println("Print out Background");
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }
    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        System.out.println("Scenario");
        new LoginPage().login(ConfigReader.getProperty("username1"),ConfigReader.getProperty("password1"));

    }
    @Then("I should be able to login and land on homepage")
    public void i_should_be_able_to_login_and_land_on_homepage() {

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?"));

        Driver.quitDriver();
    }
    @When("I use invalid credentials")
    public void i_use_invalid_credentials() {
        new LoginPage().login("duotech","duotech");

    }
    @Then("I should not be able to login and get error message")
    public void i_should_not_be_able_to_login_and_get_error_message() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Your username or password was incorrect"));
        Driver.quitDriver();

    }
    @When("I use empty credentials")
    public void i_use_empty_credentials() {
        new LoginPage().login("","");

    }
    @Then("I should not be able to login")
    public void i_should_not_be_able_to_login() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("url")));
        Driver.quitDriver();
    }

    @When("I use valid username and invalid password")
    public void i_use_valid_username_and_invalid_password() {
        new LoginPage().login(ConfigReader.getProperty("username1"),"hdssghgdhja");
    }




}
