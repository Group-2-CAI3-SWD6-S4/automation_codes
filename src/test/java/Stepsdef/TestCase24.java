package Stepsdef;

import Pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCase24 {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    SignupPage signupPage;
    LoginPage loginPage;
    AccountCreatedPage accountCreatedPage;
    CartPage cartPage;
    DeletePage deletePage;
    PaymentPage paymentPage;

    @Given("user opens home page, adds products to cart, clicks cart button, clicks proceed to checkout, clicks registerlogin button and creates an account")
    public void user_opens_home_page_adds_products_to_cart_clicks_cart_button_clicks_proceed_to_checkout_clicks_registerlogin_button_and_creates_an_account() {
        boolean isHomeVisible = homePage.verifyHomePage();
        Assert.assertTrue(isHomeVisible, "Home page is not visible!");

        homePage.addProductToCart();
        cartPage = homePage.clickOnViewCart();
        String actualText = cartPage.getShoppingCartText();
        String expectedText = "Shopping Cart";
        Assert.assertTrue(actualText.contains(expectedText),"shopping cart text mismatch");
        cartPage.clickOnProceedToCheckOut();
        loginPage = cartPage.clickRegisterLoginLink();

        loginPage.insertName("ash");
        loginPage.insertSignupEmail("ash123456@gmail.com");
        signupPage = loginPage.clickOnSignupButton();
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

        String actualResult = accountCreatedPage.getAccountCreatedMessage();
        String expectedResult = "ACCOUNT CREATED!";
        Assert.assertTrue(actualResult.contains(expectedResult),"account created message mismatch");

        homePage = accountCreatedPage.clickOnContinueButton();
        actualResult = homePage.getLoggedinMessage();
        expectedResult = "Logged in as ";
        Assert.assertTrue(actualResult.contains(expectedResult), "Login success message mismatch.");

        cartPage = homePage.clickOnViewCart();
        cartPage.clickOnProceedToCheckOut();
        actualText =  cartPage.getAddressDetailsText();
        expectedText = "Address Details";
        Assert.assertTrue(actualText.contains(expectedText),"address details mismatch");

        cartPage.insertCommentText("comment");

        paymentPage = cartPage.clickPlaceOrderButton();
        paymentPage.insertNameOnCard("ash");
        paymentPage.insertCardNumber("123456");
        paymentPage.insertCvcBox("311");
        paymentPage.insertExpiratonMonth("12");
        paymentPage.insertExpirationYear("2030");
        paymentPage.clickConfirmOrderButton();

        String actualMessage = paymentPage.getPaymentsuccessMessage();
        String expectedMessage = "Congratulations! Your order has been confirmed!";
        Assert.assertTrue(actualMessage.contains(expectedMessage),"payment message mismatch");

        paymentPage.clickOnDownloadInvoiceButton();
        homePage = paymentPage.clickOnContinueButton();
        deletePage= homePage.clickOnDeleteAccountButton();
        actualMessage = deletePage.getDeleteSuccessMessage();
        expectedMessage = "ACCOUNT DELETED!";
        Assert.assertTrue(actualMessage.contains(expectedMessage),"account deleted message mismatch");
        deletePage.clickContinueButton();
    }

    @When("when user clicks cart button, then clicks proceed to checkout, enters comment and click place order button, enters payment details and click pay and confirm order")
    public void whenUserClicksCartButtonThenClicksProceedToCheckoutEntersCommentAndClickPlaceOrderButtonEntersPaymentDetailsAndClickPayAndConfirmOrder() {
    }

    @Then("success message appears to user, user clicks download invoice, clicks continue and deletes account successfully")
    public void successMessageAppearsToUserUserClicksDownloadInvoiceClicksContinueAndDeletesAccountSuccessfully() {
    }
}
