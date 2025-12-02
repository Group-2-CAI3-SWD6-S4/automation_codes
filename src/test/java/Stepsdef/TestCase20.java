package Stepsdef;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class TestCase20 {
    private static final Logger log = LoggerFactory.getLogger(TestCase20.class);
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage;
    CartPage cartPage;
    LoginPage loginPage;

    @Given("user opens home page, clicks on products button, enters product name in search input and clicks search")
    public void user_opens_home_page_clicks_on_products_button_enters_product_name_in_search_input_and_clicks_search() {
        boolean isHomeVisible = homePage.verifyHomePage();
        Assert.assertTrue(isHomeVisible, "Home page is not visible!");
        productsPage = homePage.clickOnProductsLink();
        String actualText = productsPage.getAllProductsHeader();
        String expectedText = "ALL PRODUCTS";
        Assert.assertTrue(actualText.contains(expectedText),"all products text mismatch");
        productsPage.insertSearchBar("Blue Top");
        productsPage.clickOnSearchButton();
        actualText = productsPage.getSearchedProductsHeader();
        expectedText = "SEARCHED PRODUCTS";
        Assert.assertTrue(actualText.contains(expectedText),"searched products text mismatch");

    }

    @When("user adds products to cart and clicks cart button and clicks signuplogin button")
    public void userAddsProductsToCartAndClicksCartButtonAndClicksSignuploginButton() {
        productsPage.hoverAndAddToCart(1);
        cartPage = productsPage.clickOnviewCartLink();
        cartPage.getShoppingCartText();
        loginPage = cartPage.clickRegisterLoginLink();
        loginPage.insertEmail("ash123456@gmail.com");
        loginPage.insertPassword("ash123");
        homePage = loginPage.clickOnloginButton();
    }

    @Then("user navigates to cart page and can see the added products")
    public void userNavigatesToCartPageAndCanSeeTheAddedProducts() {
        cartPage = homePage.clickOnViewCart();
        cartPage.getShoppingCartText();
    }
}
