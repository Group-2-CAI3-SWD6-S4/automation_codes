package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //locators
    private By signupLoginButton = By.cssSelector("a[href='/login']");
    private By productsLink = By.xpath("//a[@href='/products']");
    private By loggedinMessage = By.xpath("//a[contains(text(), 'Logged in')]");
    private By homePageTitle = By.xpath("//h2[contains(text(),'Full-Fledged')]");
    private By addProductToCart = By.cssSelector(".btn.btn-default.add-to-cart");
    private By productAddedMessage = By.xpath("//div[@class='modal-content']//p");
    private By viewCartButton = By.cssSelector("a[href='/view_cart']");
    private By categorySideBar = By.xpath("//h2[contains(text(),'Category')]");
    private By womenArrow = By.xpath("//a[normalize-space()='Women']/span/i");
    private By dressSubcategory = By.xpath("//a[normalize-space()='Dress']");

    //actions

    public LoginPage clickOnsignupLoginButton(){
        driver.findElement(signupLoginButton).click();
        return new LoginPage(driver);
    }
    public ProductsPage clickOnProductsLink(){
        driver.findElement(productsLink).click();
        return new ProductsPage(driver);
    }
    public String getLoggedinMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loggedinMessage)).getText();
    }
    public boolean verifyHomePage(){
        return driver.findElement(homePageTitle).isDisplayed();
    }
    public void hoverOverProduct(WebElement productElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(productElement).perform();
    }
    public void addProductToCart(){
        WebElement productButton = driver.findElement(addProductToCart);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productButton);
    }
    public String getProductAddedMessage() {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productAddedMessage));
        String message = messageElement.getText();

        WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCart);

        return message;
    }
    public CartPage clickOnViewCart(){
        wait.until(ExpectedConditions.elementToBeClickable(viewCartButton)).click();
        return new CartPage(driver);
    }
    public String getCategorySideBar(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(categorySideBar));
        return driver.findElement(categorySideBar).getText();
    }
    public void clickWomenCategory(){
        WebElement women = wait.until(ExpectedConditions.visibilityOfElementLocated(womenArrow));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 600);");
        wait.until(ExpectedConditions.elementToBeClickable(womenArrow));
        women.click();
    }
    public CategoryPage clickDressSubcategory(){
        WebElement dress = wait.until(ExpectedConditions.elementToBeClickable(dressSubcategory));
        dress.click();
        return new CategoryPage(driver);
    }
}


