package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
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

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SignUpStepDefs extends TestBase {



    @Given("The user is on SignUp page")
    public void the_user_is_on_sign_up_page() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        loginPage.signUpLink.click();

    }

    @When("I fill out all input fields with proper credentials and click submit button")
    public void iFillOutAllInputFieldsWithProperCredentialsAndClickSubmitButton()
     {

         SignUpPage page = new SignUpPage();
        page.firstNameField.sendKeys(firstName);
        page.lastNameField.sendKeys(lastName);
        page.emailField.sendKeys(email);
        page.passwordField.sendKeys(pass);
        page.signUpButtonField.click();


     }
    @Then("I should be land on login page")
    public void iShouldBeLandOnLoginPage() throws SQLException {
        //String expectedPage = "duobank-env.eba-hjmrxg9a.ust-eas-2.elasticbeanstalk.com/index.php";
        new WebDriverWait(Driver.getDriver(), 5).until(ExpectedConditions.urlToBe(loginUrl));
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),loginUrl);

        DBUtility.updateQuery("delete from tbl_user where email='"+email+"'");

    }


    @When("The user enters the invalid credentials as {string} for first name, {string} for last name, {string} for email, and {string} for password")
    public void theUserEntersTheInvalidCredentialsAsForUsernameForFirstNameForLastNameForEmailAndForPassword(String first_Name, String last_Name, String e_mail, String password) {

        SignUpPage page = new SignUpPage();
       page.firstNameField.sendKeys(first_Name);
       page.lastNameField.sendKeys(last_Name);
       page.emailField.sendKeys(e_mail);
       page.passwordField.sendKeys(password);
       page.signUpButtonField.click();
    }
    @Then("User should not going to another page")
    public void userShouldNotGoingToAnotherPage() {
        String expectedURL = "http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/register.php";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), expectedURL);
    }
    @When("The user enters the valid credentials as {string} for last name, {string} for email, and {string} for password")
    public void theUserEntersTheValidCredentialsAsForUsernameForLastNameForEmailAndForPassword(String last_Name, String e_mail, String password) {
        SignUpPage page = new SignUpPage();
        page.lastNameField.sendKeys(last_Name);
        page.emailField.sendKeys(e_mail);
        page.passwordField.sendKeys(password);
        page.signUpButtonField.click();
    }
    @When("The user enters the valid credentials as {string} for first name, {string} for email, and {string} for password")
    public void theUserEntersTheValidCredentialsAsForUsernameForFirstNameForEmailAndForPassword(String first_Name, String e_mail, String password) {
        SignUpPage page = new SignUpPage();
        page.firstNameField.sendKeys(first_Name);
        page.emailField.sendKeys(e_mail);
        page.passwordField.sendKeys(password);
        page.signUpButtonField.click();
    }

    @When("The user click on SignUp link and enters the valid credentials as {string} for first name, {string} for last name, {string} for email, and {string} for password")
    public void theUserClickOnSignUpLinkAndEntersTheValidCredentialsAsForUsernameForFirstNameForLastNameForEmailAndForPassword(String first_name, String last_name, String e_Mail, String passw) {
        SignUpPage page = new SignUpPage();
       page.firstNameField.sendKeys(first_name);
       page.lastNameField.sendKeys(last_name);
       page.emailField.sendKeys(e_Mail);
       page.passwordField.sendKeys(passw);
       page.signUpButtonField.click();
    }
    @Then("User should be added to database")
    public void userShouldBeAddedToDatabase() throws SQLException {

        String query = "select count(*) from tbl_user where email = 'lololulu@gmail.com'";
        List<Map<String, Object>> maps = DBUtility.getQueryResultListOfMaps(query);
        System.out.println("maps = " + maps);
        long result = (long)(maps.get(0).get("count(*)"));
        Assert.assertEquals(result, 1);

        DBUtility.updateQuery("delete from tbl_user where first_name='Lulu'");

    }

}

