package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    WebDriver driver;
    public PaymentPage(WebDriver driver) {
        this.driver=driver;
    }

    //Locators
    private By nameOnCardBox = By.name("name_on_card");
    private By cardNumberBox = By.name("card_number");
    private By cvcBox = By.name("cvc");
    private By expirationMonthBox = By.name("expiry_month");
    private By expirationYearBox = By.name("expiry_year");
    private By payConfirmOrderButton = By.id("submit");
    private By paymentSuccessMessage = By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]");
    private By deleteAccountButton = By.linkText("Delete Account");
    private By downloadInvoiceButton = By.cssSelector("a[href='/download_invoice/0']");
    private By continueButton = By.cssSelector("a[data-qa='continue-button']");



    //Actions
    public void insertNameOnCard(String nameOnCard){
        driver.findElement(nameOnCardBox).sendKeys(nameOnCard);
    }
    public void insertCardNumber(String cardNumber){
        driver.findElement(cardNumberBox).sendKeys(cardNumber);
    }
    public void insertCvcBox(String CVC){
        driver.findElement(cvcBox).sendKeys(CVC);
    }
    public void insertExpiratonMonth(String  expirationMonth){
        driver.findElement(expirationMonthBox).sendKeys(expirationMonth);
    }
    public void insertExpirationYear(String expirationYear){
        driver.findElement(expirationYearBox).sendKeys(expirationYear);
    }
    public void clickConfirmOrderButton(){
        driver.findElement(payConfirmOrderButton).click();
    }
    public String getPaymentsuccessMessage(){
        String message = driver.findElement(paymentSuccessMessage).getText();
        return message;
    }
    public DeletePage clickDeleteAccount(){
        driver.findElement(deleteAccountButton).click();
        return new DeletePage(driver);
    }
    public void clickOnDownloadInvoiceButton(){
        driver.findElement(downloadInvoiceButton).click();
    }
    public HomePage clickOnContinueButton(){
        driver.findElement(continueButton).click();
        return new HomePage(driver);
    }

}
