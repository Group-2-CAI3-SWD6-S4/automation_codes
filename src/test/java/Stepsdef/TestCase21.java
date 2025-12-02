package Stepsdef;

import Pages.HomePage;
import Pages.ItemPage;
import Pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCase21 {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage;
    ItemPage itemPage;

    @Given("user opens home page, clicks on products button then view product button")
    public void user_opens_home_page_clicks_on_products_button_then_view_product_button() {
        boolean isHomeVisible = homePage.verifyHomePage();
        Assert.assertTrue(isHomeVisible, "Home page is not visible!");

        productsPage = homePage.clickOnProductsLink();
        String actualText = productsPage.getAllProductsHeader();
        String expectedText = "ALL PRODUCTS";
        Assert.assertTrue(actualText.contains(expectedText),"all products text mismatch");

        itemPage = productsPage.clickOnViewProductButton();
        actualText = itemPage.getWriteYourReviewText();
        expectedText = "WRITE YOUR REVIEW";
        Assert.assertTrue(actualText.contains(expectedText),"write you review text mismatch");
    }

    @When("user enters name, email and the review and clicks submit button")
    public void userEntersNameEmailAndTheReviewAndClicksSubmitButton() {
        itemPage.insertName("ash");
        itemPage.insertEmail("ash123456@gmail.com");
        itemPage.insertReview("product review");
        itemPage.clickOnSubmitButton();

    }

    @Then("success message appears to the user")
    public void successMessageAppearsToTheUser() {
        String actualText = itemPage.getSuccessMessage();
        String expectedText = "Thank you for your review.";
        Assert.assertTrue(actualText.contains(expectedText),"success message mismatch");
    }
}
