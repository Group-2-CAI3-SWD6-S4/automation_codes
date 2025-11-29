package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver=driver;
    }

    //Locators
    private By shoppingCartText = By.xpath("//li[@class='active' and text()='Shopping Cart']");
    private By proceedToCheckOutButton = By.xpath("//a[text()='Proceed To Checkout']");
    private By addressDetailsText = By.xpath("//h2[text()='Address Details']");
    private By commentBox = By.name("message");
    private By placeOrderButton = By.xpath("//a[text()='Place Order']");
    private By registerLoginLink = By.xpath("//a[.//u[text()='Register / Login']]");


    //Actions
    public String getShoppingCartText(){
        String Message = driver.findElement(shoppingCartText).getText();
        return Message;
    }
    public void clickOnProceedToCheckOut(){
        driver.findElement(proceedToCheckOutButton).click();
    }
    public String getAddressDetailsText(){
        String message = driver.findElement(addressDetailsText).getText();
        return message;
    }
    public void insertCommentText(String comment){
        driver.findElement(commentBox).sendKeys(comment);
    }
    public PaymentPage clickPlaceOrderButton(){
        driver.findElement(placeOrderButton).click();
        return new PaymentPage(driver);
    }
    public LoginPage clickRegisterLoginLink(){
        driver.findElement(registerLoginLink).click();
        return new LoginPage(driver);
    }
}
