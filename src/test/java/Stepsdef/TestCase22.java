package Stepsdef;

import Pages.CartPage;
import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class TestCase22 {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    CartPage cartPage;

    @Given("user opens home page, scrolls to the bottom of page")
    public void user_opens_home_page_scrolls_to_the_bottom_of_page() {
        boolean isHomeVisible = homePage.verifyHomePage();
        Assert.assertTrue(isHomeVisible, "Home page is not visible!");

        homePage.checkFooterSection();
        String actualText = homePage.getRecommendedProductsHeader();
        String expectedText = "RECOMMENDED ITEMS";
        Assert.assertTrue(actualText.contains(expectedText),"recommended items header mismatch");

    }

    @When("user clicks on add to cart on recommended product and click on view cart")
    public void userClicksOnAddToCartOnRecommendedProductAndClickOnViewCart() {
//        homePage.clickOnAddToCartRecommendedItem();
//        cartPage = homePage.clickOnViewCart();
        homePage.clickOnAddToCartRecommendedItem();
        cartPage = homePage.clickOnViewCart();


    }

    @Then("that product is displayed in cart page")
    public void thatProductIsDisplayedInCartPage() {
        String expectedProduct = Hooks.scenarioProductName.toString();
        boolean isPresent = cartPage.isProductInCart(expectedProduct);
        Assert.assertTrue(isPresent, "Product not found in cart!");
    }
}
