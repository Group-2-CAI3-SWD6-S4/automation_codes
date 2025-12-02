package Stepsdef;

import Pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCase15 {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    CartPage cartPage;
    PaymentPage paymentPage;
    AccountCreatedPage accountCreatedPage;

    @Given("User opens home page and clicks signuplogin, fills all details in signup and creates account,adds products to cart and clicks cart button")
    public void user_opens_home_page_and_clicks_signup_login_fills_all_details_in_signup_and_creates_account_adds_products_to_cart_and_clicks_cart_button() {
        //verify homepage is displayed
        boolean isHomeVisible = homePage.verifyHomePage();
        Assert.assertTrue(isHomeVisible, "Home page is not visible!");

        //register
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

//        accountCreatedPage.closeAdsIfPresent();

        String actualResult = accountCreatedPage.getAccountCreatedMessage();
        String expectedResult = "ACCOUNT CREATED!";
        Assert.assertTrue(actualResult.contains(expectedResult),"account created message mismatch");

        //click contiue button and verify logged in as
        homePage = accountCreatedPage.clickOnContinueButton();
        actualResult = homePage.getLoggedinMessage();
        expectedResult = "Logged in as ";
        Assert.assertTrue(actualResult.contains(expectedResult), "Login success message mismatch.");

        //add product to cart and proceed to checkout
        homePage.addProductToCart();
        actualResult = homePage.getProductAddedMessage();
        expectedResult = "Your product has been added to cart.";
        Assert.assertTrue(actualResult.contains(expectedResult),"product message mismatch");

        homePage.closeCartModalIfVisible();
        cartPage = homePage.clickOnViewCart();

        actualResult = cartPage.getShoppingCartText();
        expectedResult = "Shopping Cart";
        Assert.assertTrue(actualResult.contains(expectedResult),"cart message mismatch");

    }

    @When("User clicks proceed to checkout, enters comment and click place order, enters payment details and click on pay and confirm order button")
    public void userClicksProceedToCheckoutEntersCommentAndClickPlaceOrderEntersPaymentDetailsAndClickOnPayAndConfirmOrderButton() {
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

    @Then("success message appears to user and user deletes account successfully")
    public void successMessageAppearsToUserAndUserDeletesAccountSuccessfully() {
        String actualMessage = paymentPage.getPaymentsuccessMessage();
        String expectedMessage = "Congratulations! Your order has been confirmed!";
        Assert.assertTrue(actualMessage.contains(expectedMessage),"payment message mismatch");

        DeletePage deletePage = paymentPage.clickDeleteAccount();
        String actualDeleteMessage = deletePage.getDeleteSuccessMessage();
        String expectedDeleteMessage = "ACCOUNT DELETED!";
        Assert.assertTrue(actualDeleteMessage.contains(expectedDeleteMessage),"delete message mismatch");
    }
}
