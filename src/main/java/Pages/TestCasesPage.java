package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage {
    WebDriver driver;
    public TestCasesPage(WebDriver driver) {
        this.driver=driver;
    }

    //Locators
    private By testCasesHeader = By.xpath("//h2/b[contains(text(),'Test Cases')]");

    //Actions
    public String getTestCasesHeader(){
        String text = driver.findElement(testCasesHeader).getText();
        return text;
    }
}
