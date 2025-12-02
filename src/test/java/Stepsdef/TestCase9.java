package Stepsdef;

import Pages.HomePage;
import Pages.ProductsPage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCase9 {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage;

    @Given("User opens homepage and clicks on products button")
    public void user_opens_homepage_and_clicks_on_products_button() {
        homePage.verifyHomePage();
        productsPage = homePage.clickOnProductsLink();
    }

    @When("User enters product name in search input and clicks search button")
    public void userEntersProductNameInSearchInputAndClicksSearchButton() {
        productsPage.insertSearchBar("Blue Top");
        productsPage.clickOnSearchButton();
    }

    @Then("Products related to search are visable")
    public void productsRelatedToSearchAreVisable() {
        String actualText = productsPage.getSearchedProductsHeader();
        String expectedText = "SEARCHED PRODUCTS";
        Assert.assertTrue(actualText.contains(expectedText),"searched products text mismatch");
    }
}
