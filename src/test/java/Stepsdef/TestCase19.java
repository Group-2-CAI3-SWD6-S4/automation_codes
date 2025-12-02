package Stepsdef;

import Pages.HomePage;
import Pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCase19 {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage;

    @Given("user opens home page, clicks on any brand name")
    public void user_opens_home_page_clicks_on_any_brand_name() {
        boolean isHomeVisible = homePage.verifyHomePage();
        Assert.assertTrue(isHomeVisible, "Home page is not visible!");

        productsPage = homePage.clickOnProductsLink();

        String actualText = productsPage.getBrandsHeader();
        String expectedText = "BRANDS";
        Assert.assertTrue(actualText.contains(expectedText),"brands header text mismatch");

    }

    @When("user is nagvigated to the brand page and brand products are displayed,user clicks on any other link on left side bar")
    public void userIsNagvigatedToTheBrandPageAndBrandProductsAreDisplayedUserClicksOnAnyOtherLinkOnLeftSideBar() {
        productsPage.clickOnPoloBrand();
        String actualText = productsPage.getPoloHeader();
        String expectedText = "BRAND - POLO PRODUCTS";
        Assert.assertTrue(actualText.contains(expectedText),"brands polo header mismatch");
    }

    @Then("user is navigated to that brand page and can see products")
    public void userIsNavigatedToThatBrandPageAndCanSeeProducts() {
        productsPage.clickHAndMBrandLink();
        String actualText = productsPage.getHAndMHeader();
        String expectedText = "BRAND - H&M PRODUCTS";
        Assert.assertTrue(actualText.contains(expectedText),"brand h&m header mismatch");
    }
}
