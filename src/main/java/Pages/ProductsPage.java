package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    WebDriver driver;
    public ProductsPage(WebDriver driver) {
        this.driver=driver;
    }
    //Locators
    private By brandsHeader = By.xpath("//div[@class='brands_products']/h2[text()='Brands']");
    private By poloBrand = By.xpath("//a[@href='/brand_products/Polo']");
    private By poloHeader = By.xpath("//h2[text()='Brand - Polo Products']");
    private By hAndMBrandLink = By.xpath("//a[@href='/brand_products/H&M']");
    private By hAndMHeader = By.xpath("//h2[contains(text(),'Brand - H&M Products')]");



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
        WebElement hAndMLink = driver.findElement(hAndMBrandLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hAndMLink);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", hAndMLink);
    }
    public String getHAndMHeader(){
        String Text = driver.findElement(hAndMHeader).getText();
        return Text;
    }
}
