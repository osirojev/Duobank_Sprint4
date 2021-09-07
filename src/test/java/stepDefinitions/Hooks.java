package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.DBUtility;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before ("not @db_only")
    public void setup(){
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().manage().window().maximize();

        System.out.println("@Before hook");

    }
    @Before ("@db_only")
    public void setupDB(){
        DBUtility.createConnection();




    }
    @After ("@db_only")
    public void DBtearDownScenario(){
        DBUtility.close();




    }
    @After ("not @db_only")
    public void tearDownScenarios(Scenario scenario){
        if(scenario.isFailed()){
         byte [] screenshotAS =  ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
         scenario.attach(screenshotAS,"image/png","failedScreenShots");
        }
        System.out.println("@After Hook");



        Driver.quitDriver();

    }
}
