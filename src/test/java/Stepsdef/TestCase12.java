package Stepsdef;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCase12 {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage;
    CartPage cartPage;

    @Given("user opens home page and clicks products button, hovers over first product and clicks add to cart")
    public void user_opens_home_page_and_clicks_products_button_hovers_over_first_product_and_clicks_add_to_cart() {
        homePage.verifyHomePage();
        productsPage = homePage.clickOnProductsLink();
        productsPage.hoverAndAddToCart(1);
    }

    @When("user clicks continue shopping button, hovers over second product and clicks add to cart, clicks view cart button")
    public void userClicksContinueShoppingButtonHoversOverSecondProductAndClicksAddToCartClicksViewCartButton() {
        productsPage.clickOnContinueShoppingButton();
        productsPage.hoverAndAddToCart(2);
        cartPage = productsPage.clickOnviewCartLink();
    }

    @Then("both products are added to cart with the correct prices, quantity and total price")
    public void bothProductsAreAddedToCartWithTheCorrectPricesQuantityAndTotalPrice() {
        int items = cartPage.getNumberOfProductsInCart();
        Assert.assertEquals(items,2, "Cart should contain 2 products");
    }
}
