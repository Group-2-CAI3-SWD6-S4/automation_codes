package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountCreatedPage {
    WebDriver driver;
    WebDriverWait wait;
    public AccountCreatedPage(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    //Locators
    private By accountCreatedMessage = By.xpath("//h2[@class='title text-center']/b");
    private By continueButton = By.cssSelector("a[data-qa='continue-button']");

    //Actions
    public String getAccountCreatedMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement messageElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(accountCreatedMessage)
        );
        return messageElement.getText();
    }
    public HomePage clickOnContinueButton(){
        driver.findElement(continueButton).click();
        return new HomePage(driver);
    }
}
