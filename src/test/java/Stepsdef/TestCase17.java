package Stepsdef;

import Pages.CartPage;
import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class TestCase17 {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    CartPage cartPage;

    @Given("user opens home page, adds products to cart")
    public void user_opens_home_page_adds_products_to_cart() {


    }

    @When("user clicks cart button and cart page is displayed and user clicks X button corresponding to a product")
    public void userClicksCartButtonAndCartPageIsDisplayedAndUserClicksXButtonCorrespondingToAProduct() {
        homePage.verifyHomePage();
//        homePage.addProductToCart();
//        cartPage = homePage.clickOnViewCart();
//        String actualText  = cartPage.getShoppingCartText();
//        String expectedText = "Shopping Cart";
//        Assert.assertTrue(actualText.contains(expectedText),"shopping cart text mismatch");
//        cartPage.clickOnDeleteButton();

    }

    @Then("that product is removed from cart")
    public void thatProductIsRemovedFromCart() {
//        boolean removed = cartPage.waitUntilProductIsRemoved();
//        Assert.assertTrue(removed, "Product was NOT removed from the cart!");
    }
}
