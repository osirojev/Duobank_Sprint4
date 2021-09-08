package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.PageBase;
import pages.SignUpPage;
import utilities.ConfigReader;
import utilities.DBUtility;
import utilities.Driver;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class SignUpStepDefs extends TestBase {

    @Given("I am on SignUp page")
    public void iAmOnSignUpPage() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
//        loginPage.signUpLink.click(;)
        //Driver.getDriver().get("http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/register.php");
    }
    @When("I fill out all input fields with proper credentials and click submit button")
    public void iFillOutAllInputFieldsWithProperCredentialsAndClickSubmitButton()
     {
         signup.signUp(firstName, lastName, email, pass);
//        loginPage.signUpLink.click();
//        SignUpPage page = new SignUpPage();
//        page.firstNameField.sendKeys(firstName);
//        page.lastNameField.sendKeys(lastName);
//        page.emailField.sendKeys(email);
//        page.passwordField.sendKeys(pass);
//        page.signUpButtonField.click();


     }
    @Then("I should be land on login page")
    public void iShouldBeLandOnLoginPage() {
        //String expectedPage = "duobank-env.eba-hjmrxg9a.ust-eas-2.elasticbeanstalk.com/index.php";
        new WebDriverWait(Driver.getDriver(), 5).until(ExpectedConditions.urlToBe(loginUrl));
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),loginUrl);
    }

    @Given("I am in homepage and click on SignUp")
    public void iAmInHomepageAndClickOnSignUp() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        loginPage.signUpLink.click();
    }
    @When("The user enters the invalid credentials as {string} for username, {string} for first name, {string} for last name, {string} for email, and {string} for password")
    public void theUserEntersTheInvalidCredentialsAsForUsernameForFirstNameForLastNameForEmailAndForPassword(String string, String string2, String string3, String string4, String string5) {

    }
    @Then("User should not going to another page")
    public void userShouldNotGoingToAnotherPage() {
        String expectedURL = "http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/register.php";
        new WebDriverWait(Driver.getDriver(), 5).until(ExpectedConditions.urlToBe(loginUrl));
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), expectedURL);
    }



    }

