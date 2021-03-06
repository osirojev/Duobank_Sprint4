package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.DBUtility;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;

public class Hooks {

    @Before ("not @api")
    public void setupScenario(){
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().manage().window().maximize();


    }

    @Before ("@api")
    public void setupAPI(){

        baseURI = "http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/api";


    }

    @Before ("@db")
    public void setupDb(){

        DBUtility.createConnection();
    }
    @Before("@api")
    public void setUpApi(){
        RestAssured.baseURI = "http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/api";
    }

    @After ("@db")
    public void tearDownDb(){

        DBUtility.close();
    }


    @After("@ui")
    public void tearDownScenario(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshotAs = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotAs, "image/png" , "failedScreenshot");
        }


        Driver.quitDriver();

    }
}