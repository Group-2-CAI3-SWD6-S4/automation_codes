package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class CartPage {
    WebDriver driver;
    WebDriverWait wait;
    public CartPage(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Locators
    private By shoppingCartText = By.xpath("//li[@class='active' and text()='Shopping Cart']");
    private By proceedToCheckOutButton = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    private By addressDetailsText = By.xpath("//h2[text()='Address Details']");
    private By commentBox = By.name("message");
    private By placeOrderButton = By.xpath("//a[text()='Place Order']");
    private By registerLoginLink = By.xpath("//a[.//u[text()='Register / Login']]");
    private By signupLoginLink = By.xpath("//a[@href='/login']");

    private By footerSection = By.xpath("//footer[@id='footer']");
    private By subscriptionHeader = By.xpath("//h2[normalize-space()='Subscription']");
    private By subscribeEmailInput = By.xpath("//input[@placeholder='Your email address']");
    private By subscribeButton = By.xpath("//button[@id='subscribe']");
    private By alertSuccessMessage = By.xpath("//div[@id='success-subscribe']//div[contains(@class,'alert-success')]");
    private By cartItems = By.cssSelector(".cart_info .cart_description");
    private By productQuantity = By.xpath("//td[@class='cart_quantity']/button");
    private By deleteButton = By.xpath("(//a[@class='cart_quantity_delete'])[1]");
    private By cartProductNames = By.cssSelector(".cart_info .cart_description h4 a");
    private By deliveryAddress = By.xpath("(//ul[@id='address_delivery']//li[@class='address_address1 address_address2'])[2]");
    private By billingAddress = By.xpath("(//ul[@id='address_invoice']//li[@class='address_address1 address_address2'])[2]");

    private By deleteAccountLink = By.cssSelector("a[href='/delete_account']");





    //Actions
    public String getShoppingCartText(){
        String Message = driver.findElement(shoppingCartText).getText();
        return Message;
    }
    public void clickOnProceedToCheckOut(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement proceed = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[contains(text(),'Proceed To Checkout')]")));
        proceed.click();
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
        driver.findElement(signupLoginLink).click();
        return new LoginPage(driver);
    }
    public void scrollToFooterSectionInCart(){
        WebElement footer = driver.findElement(footerSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
        wait.until(ExpectedConditions.visibilityOf(footer));
    }
    public String getSubscriptionHeader(){
        String text = driver.findElement(subscriptionHeader).getText();
        return text;
    }
    public void insertSubscribeEmailInput(String email){
        driver.findElement(subscribeEmailInput).sendKeys(email);
    }
    public void clickOnSubscribeButton(){
        driver.findElement(subscribeButton).click();
    }
    public String getAlertSuccessMessage(){
        String message = driver.findElement(alertSuccessMessage).getText();
        return message;
    }
    public int getNumberOfProductsInCart() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItems));
        return driver.findElements(cartItems).size();
    }
    public int getProductQuantity() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantity));
        String value = driver.findElement(productQuantity).getText();
        return Integer.parseInt(value);
    }
    public void clickOnDeleteButton() {
        WebElement delete = wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButton));
        delete.click();
    }
    public boolean waitUntilProductIsRemoved() {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(deleteButton));
    }
    public boolean isProductInCart(String productName) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartProductNames));
        return driver.findElements(cartProductNames)
                .stream()
                .anyMatch(p -> p.getText().equalsIgnoreCase(productName));
    }
    public List<String> getProductsInCart() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartProductNames));
        List<WebElement> products = driver.findElements(cartProductNames);

        // Extract the text (product names) from the elements
        List<String> productNames = new ArrayList<>();
        for (WebElement product : products) {
            productNames.add(product.getText());
        }
        return productNames;
    }
    public String getDeliveryAddress(){
        String text = driver.findElement(deliveryAddress).getText();
        return text;
    }
    public String getBillingAddress(){
        String text= driver.findElement(billingAddress).getText();
        return text;
    }
    public DeletePage clickOnDeleteAccountLink(){
        driver.findElement(deleteAccountLink).click();
        return new DeletePage(driver);
    }
}
