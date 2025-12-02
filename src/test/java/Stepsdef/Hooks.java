package Stepsdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {
    public  static WebDriver driver;
    public static Object scenarioProductName;

    @Before
    public void setup(){
        if (driver == null) {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }
    @After
    public void closeBrowser(){
//        driver.quit();
    }
    public static WebDriver getDriver(){
        return driver;
    }
}
