package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import pages.ApplicationPage;
import pages.ExpensesPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Expenses {
    String employmentAndIncomePageTextExpected="Employment and Income";
    @Given("I am on Expenses Page checking function")

    public void IAmOnExpensesPageCheckingFunction(){

        Driver.getDriver().get(ConfigReader.getProperty("mortgageAppUrl"));
        String purposeOfLoan = "Purchase A Home";
        String estimatedPurchasePrice = "" + (500000 + (int)(Math.random() * 500000));
        String downPaymentAmount = "" + (100000 + (int)(Math.random() * 400000));
        String paymentSourceAnotherType = "Other type of Down Payment";
        String realtorInfo = new Faker().name().fullName() + ", " + new Faker().internet().emailAddress();

        ApplicationPage appPage = new ApplicationPage();

        appPage.realtorInfoField.sendKeys(realtorInfo);
        appPage.workingWithLoanOfficerNO.click(); // ARE YOU WORKING WITH A REALTOR? - NO
        appPage.purposeOfLoanButton.click();
        appPage.purposeOfLoanField.sendKeys(purposeOfLoan, Keys.ENTER);
        appPage.estimatedPurchasePriceField.sendKeys(estimatedPurchasePrice);
        appPage.downPaymentAmountField.sendKeys(downPaymentAmount);
        appPage.downPaymentSourceButton.click();
        appPage.downPaymentSourceField.sendKeys(paymentSourceAnotherType, Keys.ENTER);
        appPage.nextButton.click();

       String firstName = new Faker().name().firstName();
       String  lastName = new Faker().name().lastName();
       String  email = new Faker().internet().emailAddress();
        String dateOfBirth = "05/05/1985";
       String  ssn = "123-45-6789";
       String  cellNumber = "121-100-0101";
        String homeNumber = "222-100-0101";
       String  married = "Married";

        ApplicationPage appPag = new ApplicationPage();
        appPag.firstNameField.sendKeys(firstName);
        appPag.lastNameField.sendKeys(lastName);
        appPag.emailField.sendKeys(email);
        appPag.dateOfBirthField.sendKeys(dateOfBirth);
        appPag.ssnField.sendKeys(ssn);
        appPag.maritalStatusButton.click();
        appPag.maritalStatusField.sendKeys(married, Keys.ENTER);
        appPag.cellPhoneField.sendKeys(cellNumber);
        appPag.homePhoneField.sendKeys(homeNumber);
        appPag.nextButton.click();





    }

    @When("I click on own button")
    public void IClickOnOwnButton(){

        ExpensesPage exPage = new ExpensesPage();
        exPage.ownButton.click();


    }

    @Then("Specific text place holder should appear on screen")

    public void SpecificTextPlaceHolderShouldAppearOnScreen (){
        ExpensesPage exPage = new ExpensesPage();
        Assert.assertEquals(exPage.firstMortgageTotalPaymentField.getAttribute("placeholder"),"First Mortagage Total Payment");
    }

    @When("I click on rent button")
    public void IClickOnRentButton(){

        ExpensesPage exPage = new ExpensesPage();

        exPage.rentButton.click();
    }

    @Then("Monthly rental payment place holder should appear")
    public void MonthlyRentalPaymentPlaceHolderShouldAppear(){

        ExpensesPage exPage = new ExpensesPage();
        Assert.assertEquals(exPage.monthlyRentalPayment.getAttribute("placeholder"),"MONTHLY RENTAL PAYMENT");


    }



    @When("I add correct amount and click next button")
    public void IAddCorrectAmountAndClickNextButton(){
        ExpensesPage exPage = new ExpensesPage();
        exPage.ownButton.click();
        exPage.firstMortgageTotalPaymentField.sendKeys("100000");
        exPage.nextButton.click();



    }
    @Then("Should land on next page")
    public void ShouldLandOnNextPage(){
        ExpensesPage exPage = new ExpensesPage();
        Assert.assertEquals(exPage.employmentAndIncomePageText.getText(), employmentAndIncomePageTextExpected);


    }










}
