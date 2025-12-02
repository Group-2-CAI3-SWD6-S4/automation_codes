package Stepsdef;

import Pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class TestCase16 {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    CartPage cartPage;
    PaymentPage paymentPage;
    LoginPage loginPage;
    DeletePage deletePage;

    @Given("user opens home page,and loggs in,adds products to cart,views cart and clicks proceed to checkout")
    public void user_opens_home_page_and_loggs_in_adds_products_to_cart_views_cart_and_clicks_proceed_to_checkout() {

        //steps
        homePage.verifyHomePage();
        loginPage = homePage.clickOnsignupLoginButton();

        loginPage.insertEmail("ash123456@gmail.com");
        loginPage.insertPassword("ash123");
        homePage = loginPage.clickOnloginButton();


        //Assertions
        String actualResult = homePage.getLoggedinMessage();
        String expectedResult = "Logged in as ";
        Assert.assertTrue(actualResult.contains(expectedResult), "Login success message mismatch.");

        boolean isHomeVisible = homePage.verifyHomePage();

        //assertions
        Assert.assertTrue(isHomeVisible, "Home page is not visible!");

        homePage.addProductToCart();

        //Assertions
        actualResult = homePage.getProductAddedMessage();
        expectedResult = "Your product has been added to cart.";
        Assert.assertTrue(actualResult.contains(expectedResult), "product message mismatch");

        homePage.waitForCartModalToDisappear();
        cartPage = homePage.clickOnViewCart();

        actualResult = cartPage.getShoppingCartText();
        expectedResult = "Shopping Cart";
        Assert.assertTrue(actualResult.contains(expectedResult), "cart message mismatch");

        cartPage.clickOnProceedToCheckOut();
        String actualText = cartPage.getAddressDetailsText();
        String ExpectedText = "Address Details";
        Assert.assertTrue(actualText.contains(ExpectedText));
    }

    @When("user verifies address and order details, enters comment and clicks place order, user enters payment details and clicks pay and confirm button")
    public void userVerifiesAddressAndOrderDetailsEntersCommentAndClicksPlaceOrderUserEntersPaymentDetailsAndClicksPayAndConfirmButton() {
        cartPage.insertCommentText("comment");

        paymentPage = cartPage.clickPlaceOrderButton();
        paymentPage.insertNameOnCard("ash");
        paymentPage.insertCardNumber("123456");
        paymentPage.insertCvcBox("311");
        paymentPage.insertExpiratonMonth("12");
        paymentPage.insertExpirationYear("2030");
        paymentPage.clickConfirmOrderButton();
    }

    @Then("success message appears to user, user deletes account successfully")
    public void successMessageAppearsToUserUserDeletesAccountSuccessfully() {
        String actualMessage = paymentPage.getPaymentsuccessMessage();
        String expectedMessage = "Congratulations! Your order has been confirmed!";
        Assert.assertTrue(actualMessage.contains(expectedMessage), "payment message mismatch");

        deletePage = paymentPage.clickDeleteAccount();
        String actualDeleteMessage = deletePage.getDeleteSuccessMessage();
        String expectedDeleteMessage = "ACCOUNT DELETED!";
        Assert.assertTrue(actualDeleteMessage.contains(expectedDeleteMessage), "delete message mismatch");
    }
}
