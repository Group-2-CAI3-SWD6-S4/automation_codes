package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage {
    WebDriver driver;
    public ItemPage(WebDriver driver) {
        this.driver=driver;
    }

    //Locators
    private By productName = By.xpath("//div[@class='product-information']//h2");
    private By categoryName = By.xpath("//div[@class='product-information']//p[starts-with(normalize-space(),'Category')]");
    private By priceText = By.xpath("//span[contains(text(),'Rs.')]");
    private By quantityInput = By.xpath("//input[@id='quantity']");
    private By availability = By.xpath("//p[b[normalize-space()='Availability:']]");
    private By condition = By.xpath("//p[b[normalize-space()='Condition:']]");
    private By brand = By.xpath("//p[b[normalize-space()='Brand:']]");
    private By addToCartButton = By.cssSelector("button.btn.btn-default.cart");
    private By viewCartLink = By.cssSelector("p.text-center > a[href='/view_cart']");
    private By writeYourReview = By.cssSelector("a[href='#reviews'][data-toggle='tab']");
    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By reviewField = By.id("review");
    private By submitButton = By.id("button-review");
    private By successMessage = By.cssSelector("div.alert-success.alert > span");


    //Actions
    public void checkProductdetails(){
        driver.findElement(productName).isDisplayed();
        driver.findElement(categoryName).isDisplayed();
        driver.findElement(priceText).isDisplayed();
        driver.findElement(quantityInput).isDisplayed();
        driver.findElement(availability).isDisplayed();
        driver.findElement(condition).isDisplayed();
        driver.findElement(brand).isDisplayed();
    }
    public void increaseQuantity(int n){
        WebElement quantityField = driver.findElement(quantityInput);
        quantityField.clear();
        quantityField.sendKeys(String.valueOf(n));
    }
    public void clickOnAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }
    public CartPage clickOnViewCartLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(viewCartLink));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCart);
        return new CartPage(driver);
    }
    public String getWriteYourReviewText(){
        String text = driver.findElement(writeYourReview).getText();
        return text;
    }
    public void insertName(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    public void insertEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void insertReview(String review){
        driver.findElement(reviewField).sendKeys(review);
    }
    public void clickOnSubmitButton(){
        driver.findElement(submitButton).click();
    }
    public String getSuccessMessage(){
        String text = driver.findElement(successMessage).getText();
        return text;
    }
}
