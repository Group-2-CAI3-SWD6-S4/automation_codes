package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage {
    WebDriver driver;
    public CategoryPage(WebDriver driver) {
        this.driver=driver;
    }

    //Locators
    private By categoryPageTitle = By.cssSelector("h2.title.text-center");
    private By menCategory = By.xpath("//a[@href='#Men']");
    private By menTShirtsSubCategory = By.xpath("//div[@id='Men']//a[contains(text(),'Tshirts')]");
    private By menCategoryTitle = By.xpath("//h2[contains(text(),'Men - Tshirts Products')]");

    //Actions
    public String getCategoryText(){
        String text = driver.findElement(categoryPageTitle).getText();
        return text;
    }
    public void clickMenCategory(){
        driver.findElement(menCategory).click();
    }
    public void clickMenTshirtsSubcategory(){
        driver.findElement(menTShirtsSubCategory).click();
    }
    public String getMenCategoryTitle(){
        String text = driver.findElement(menCategoryTitle).getText();
        return text;
    }

}
