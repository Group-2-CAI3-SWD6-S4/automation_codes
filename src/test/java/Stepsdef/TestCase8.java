package Stepsdef;

import Pages.HomePage;
import Pages.ItemPage;
import Pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCase8 {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage;
    ItemPage itemPage;

    @Given("User opens home page and clicks on products button")
    public void user_opens_home_page_and_clicks_on_products_button() {
        homePage.verifyHomePage();
        //click on products button
        productsPage = homePage.clickOnProductsLink();
        String actualText = productsPage.getAllProductsHeader();
        String expectedText = "ALL PRODUCTS";
        Assert.assertTrue(actualText.contains(expectedText),"all products text mismatch");
    }

    @When("User clicks on view product")
    public void userClicksOnViewProduct() {
        productsPage.clickOnViewProductButton();
        itemPage = new ItemPage(driver);
    }

    @Then("user is landed to product detail page and can view product name, category, price, availability, condition and brand")
    public void userIsLandedToProductDetailPageAndCanViewProductNameCategoryPriceAvailabilityConditionAndBrand() {
        itemPage.checkProductdetails();
    }
}
