package Stepsdef;

import Pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TestCase14 {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    CartPage cartPage;
    PaymentPage paymentPage;
    AccountCreatedPage accountCreatedPage;

    @Given("user opens homepage, adds products to cart,clicks cart button, click proceed to checkout, click register and fill all the details and clicks continue")
    public void user_opens_homepage_adds_products_to_cart_clicks_cart_button_click_proceed_to_checkout_click_register_and_fill_all_the_details_and_clicks_continue() {
        boolean isHomeVisible = homePage.verifyHomePage();
        Assert.assertTrue(isHomeVisible, "Home page is not visible!");

        //add product to cart and proceed to checkout
        homePage.addProductToCart();
        String actualResult = homePage.getProductAddedMessage();
        String expectedResult = "Your product has been added to cart.";
        Assert.assertTrue(actualResult.contains(expectedResult),"product message mismatch");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("cartModal")));

        CartPage cartPage = homePage.clickOnViewCart();

        actualResult = cartPage.getShoppingCartText();
        expectedResult = "Shopping Cart";
        Assert.assertTrue(actualResult.contains(expectedResult),"cart message mismatch");

        cartPage.clickOnProceedToCheckOut();
        //click register login button
        cartPage.clickRegisterLoginLink();

        //fill details
        LoginPage loginPage = homePage.clickOnsignupLoginButton();

        loginPage.insertName("ash");
        loginPage.insertSignupEmail("ash123456@gmail.com");
        SignupPage signupPage  = loginPage.clickOnSignupButton();
        signupPage.insertPassword("ash123");
        signupPage.selectDay("2");
        signupPage.selectMonth("December");
        signupPage.selectYear("1992");
        signupPage.insertFirstName("ash");
        signupPage.insertLastName("ashley");
        signupPage.insertAddress("56 street");
        signupPage.selectCountry("Canada");
        signupPage.insertState("canada");
        signupPage.insertCity("ottawa");
        signupPage.insertZipCode("12345");
        signupPage.insertMobileNumber("1456987426");
        accountCreatedPage = signupPage.clickOnCreateAccountButton();

        actualResult = accountCreatedPage.getAccountCreatedMessage();
        expectedResult = "ACCOUNT CREATED!";
        Assert.assertTrue(actualResult.contains(expectedResult),"account created message mismatch");
    }

    @When("logged in as appears at top,user clicks cart button and proceed to checkout button, verify address details and order, user enters comment and click place order, and enters payment details, user clicks pay and confirm button")
    public void loggedInAsAppearsAtTopUserClicksCart_buttonAndProceedToCheckoutButtonVerifyAddressDetailsAndOrderUserEntersCommentAndClickPlaceOrderAndEntersPaymentDetailsUserClicksPayAndConfirmButton() {
        HomePage homePage = accountCreatedPage.clickOnContinueButton();
        String actualResult = homePage.getLoggedinMessage();
        String expectedResult = "Logged in as ";
        Assert.assertTrue(actualResult.contains(expectedResult), "Login success message mismatch.");

        cartPage = homePage.clickOnViewCart();
        cartPage.clickOnProceedToCheckOut();

        String actualText =  cartPage.getAddressDetailsText();
        String ExpectedText = "Address Details";
        Assert.assertTrue(actualText.contains(ExpectedText),"address details mismatch");

        cartPage.insertCommentText("comment");

        paymentPage = cartPage.clickPlaceOrderButton();
        paymentPage.insertNameOnCard("ash");
        paymentPage.insertCardNumber("123456");
        paymentPage.insertCvcBox("311");
        paymentPage.insertExpiratonMonth("12");
        paymentPage.insertExpirationYear("2030");
        paymentPage.clickConfirmOrderButton();
    }

    @Then("success message appears to user, user clicks on delete account,account deleted message appears to user")
    public void successMessageAppearsToUserUserClicksOnDeleteAccountAccountDeletedMessageAppearsToUser() {
        String actualMessage = paymentPage.getPaymentsuccessMessage();
        String expectedMessage = "Congratulations! Your order has been confirmed!";
        Assert.assertTrue(actualMessage.contains(expectedMessage),"payment message mismatch");

        DeletePage deletePage = paymentPage.clickDeleteAccount();
        String actualDeleteMessage = deletePage.getDeleteSuccessMessage();
        String expectedDeleteMessage = "ACCOUNT DELETED!";
        Assert.assertTrue(actualDeleteMessage.contains(expectedDeleteMessage),"delete message mismatch");
        deletePage.clickContinueButton();
    }
}
