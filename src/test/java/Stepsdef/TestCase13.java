package Stepsdef;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ItemPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class TestCase13 {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    ItemPage itemPage;
    CartPage cartPage;

    @Given("User opens homepage, clicks view product and increases the quantity to four")
    public void user_opens_homepage_clicks_view_product_and_increases_the_quantity_to() {
        homePage.verifyHomePage();
        itemPage = homePage.clickOnViewProductLink();
        itemPage.checkProductdetails();
        itemPage.increaseQuantity(4);
    }

    @When("User clicks add to cart then clicks view cart")
    public void userClicksAddToCartThenClicksViewCart() {
        itemPage.clickOnAddToCartButton();
        cartPage = itemPage.clickOnViewCartLink();
    }

    @Then("product is displayed in cart page with exact quantity")
    public void productIsDisplayedInCartPageWithExactQuantity() {
        int quantity = cartPage.getProductQuantity();
        org.testng.Assert.assertEquals(quantity, 4, "Product quantity in cart should be 4");
    }
}
