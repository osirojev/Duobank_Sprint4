package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmploymentPage {
    @FindBy(xpath = "//input[@id='employername1']")
    public WebElement employerNameField;

    @FindBy(xpath = "//input[@id='position1']")
    public WebElement jobPositionField;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement jobCityField;

    @FindBy(xpath = "//select[@id='state1']")
    public WebElement stateSelect;

    @FindBy(xpath = "//input[@id='start_date1']")
    public WebElement jobStartDateField;

    @FindBy(xpath = "//input[@id='grossmonthlyincome']")
    public WebElement grossMonthlyIncomeField;

    @FindBy(xpath = "//input[@id='monthlyovertime']")
    public WebElement monthlyOvertimeField;

    @FindBy(xpath = "//a[@href='#next']")
    public WebElement employmentNext;

    @FindBy(xpath = "//span[.='Credit Report'][1]")
    public WebElement creditReportPageText;










}
