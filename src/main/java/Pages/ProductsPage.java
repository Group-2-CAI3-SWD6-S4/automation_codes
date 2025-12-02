package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {
    WebDriver driver;
    WebDriverWait wait;
    public ProductsPage(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //Locators
    private By brandsHeader = By.xpath("//div[@class='brands_products']/h2[text()='Brands']");
    private By poloBrand = By.xpath("//a[@href='/brand_products/Polo']");
    private By poloHeader = By.xpath("//h2[text()='Brand - Polo Products']");
//    private By hAndMBrandLink = By.xpath("//a[@href='/brand_products/H&M']");
//    private By hAndMHeader = By.xpath("//h2[contains(text(),'Brand - H&M Products')]");

    private By hAndMBrandLink = By.xpath("//a[contains(@href, 'H&M')]");
    private By hAndMHeader = By.xpath("//h2[contains(text(),'H&M')]");


    private By allProductsHeader = By.xpath("//h2[normalize-space()='All Products']");
    private By viewProductButton = By.xpath("//a[normalize-space()='View Product']");
    private By searchBar = By.xpath("//input[@id='search_product']");
    private By searchButton = By.xpath("//button[@id='submit_search']");
    private By searchedProductsHeader = By.xpath("//h2[contains(text(),'Searched Products')]");
    private By addToCartButtons = By.cssSelector(".btn.btn-default.add-to-cart");
    private By continueShoppingButton = By.xpath("//button[@data-dismiss='modal']");
    private By viewCartLink = By.cssSelector("a[href='/view_cart']");



    //Actions
    public String getBrandsHeader(){
        String Text = driver.findElement(brandsHeader).getText();
        return Text;
    }
    public void clickOnPoloBrand(){
        driver.findElement(poloBrand).click();
    }
    public String getPoloHeader(){
        String Text = driver.findElement(poloHeader).getText();
        return Text;
    }
    public void clickHAndMBrandLink(){
//        WebElement hAndMLink = driver.findElement(hAndMBrandLink);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hAndMLink);
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", hAndMLink);

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(hAndMBrandLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
        link.click();
    }
    public String getHAndMHeader(){
        String Text = driver.findElement(hAndMHeader).getText();
        return Text;
    }
    public String getAllProductsHeader(){
        String Text = driver.findElement(allProductsHeader).getText();
        return Text;
    }
    public ItemPage clickOnViewProductButton(){
        driver.findElement(viewProductButton).click();
        return new ItemPage(driver);
    }
    public void insertSearchBar(String search){
        driver.findElement(searchBar).sendKeys(search);
    }
    public void clickOnSearchButton(){
        driver.findElement(searchButton).click();
    }
    public String getSearchedProductsHeader(){
        String text = driver.findElement(searchedProductsHeader).getText();
        return text;
    }
    public void hoverAndAddToCart(int productIndex) {
        List<WebElement> products = driver.findElements(addToCartButtons);
        WebElement product = products.get(productIndex);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);

        Actions actions = new Actions(driver);
        actions.moveToElement(product).perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product);
    }
    public void clickOnContinueShoppingButton(){
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }
    public CartPage clickOnviewCartLink(){
        driver.findElement(viewCartLink).click();
        return new CartPage(driver);
    }
}
