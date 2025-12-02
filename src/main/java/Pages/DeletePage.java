package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeletePage {
    WebDriver driver;
    public DeletePage(WebDriver driver) {
        this.driver=driver;
    }
    //Locators
    private By accountDeletedMessage = By.cssSelector(".title.text-center");
    private By deleteButton = By.xpath("//a[text()='Continue']");


    //Actions
    public String getDeleteSuccessMessage(){
        String message = driver.findElement(accountDeletedMessage).getText();
        return message;
    }
    public HomePage clickContinueButton(){
        driver.findElement(deleteButton).click();
        return new HomePage(driver);
    }
}

