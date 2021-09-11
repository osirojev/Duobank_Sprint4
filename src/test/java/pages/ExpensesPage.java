package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExpensesPage {

    @FindBy(xpath="//label[@for='expense2']")
    public WebElement ownButton;

    @FindBy(xpath="//label[.='Rent']")
    public WebElement rentButton;

    @FindBy(xpath="//input[@placeholder='First Mortagage Total Payment']")
    public WebElement firstMortgageTotalPaymentField;

    @FindBy(xpath="//input[@name='monthly_rental_payment']")
    public WebElement monthlyRentalPayment;

    @FindBy(xpath="//a[.='Next']")
    public WebElement nextButton;

    @FindBy(xpath = "//span[.='Employment and Income'][1]")
    public WebElement employmentAndIncomePageText;






}
