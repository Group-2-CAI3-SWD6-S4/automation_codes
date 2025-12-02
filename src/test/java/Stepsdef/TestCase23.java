package Stepsdef;

import Pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCase23 {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    SignupPage signupPage;
    LoginPage loginPage;
    AccountCreatedPage accountCreatedPage;
    CartPage cartPage;
    DeletePage deletePage;
    String address = "56 street";
    @Given("user opens home page, clicks on signuplogin page,fills all the details and creates an account and clicks continue")
    public void user_opens_home_page_clicks_on_signuplogin_page_fills_all_the_details_and_creates_an_account_and_clicks_continue() {
        boolean isHomeVisible = homePage.verifyHomePage();
        Assert.assertTrue(isHomeVisible, "Home page is not visible!");
        loginPage = homePage.clickOnsignupLoginButton();
        loginPage.insertName("ash");
        loginPage.insertSignupEmail("ash123456@gmail.com");
        signupPage = loginPage.clickOnSignupButton();
        signupPage.insertPassword("ash123");
        signupPage.selectDay("2");
        signupPage.selectMonth("December");
        signupPage.selectYear("1992");
        signupPage.insertFirstName("ash");
        signupPage.insertLastName("ashley");
        signupPage.insertAddress(address);
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


    }

    @When("user adds products to cart, clicks cart button and then clicks proceed to checkout, with the delivery and billing address the same as regiteration address")
    public void userAddsProductsToCartClicksCartButtonAndThenClicksProceedToCheckoutWithTheDeliveryAndBillingAddressTheSameAsRegiterationAddress() {
        String actualResult = homePage.getLoggedinMessage();
        String expectedResult = "Logged in as ";
        Assert.assertTrue(actualResult.contains(expectedResult), "Login success message mismatch.");

        homePage.addProductToCart();
        cartPage = homePage.clickOnViewCart();
        actualResult = cartPage.getShoppingCartText();
        expectedResult = "Shopping Cart";
        Assert.assertTrue(actualResult.contains(expectedResult),"shopping cart text mismatch");
        cartPage.clickOnProceedToCheckOut();

        String actualText =  cartPage.getAddressDetailsText();
        String ExpectedText = "Address Details";
        Assert.assertTrue(actualText.contains(ExpectedText),"address details mismatch");

        actualText = cartPage.getDeliveryAddress();
        Assert.assertTrue(actualText.contains(address),"delivery address mismatch");
        actualText = cartPage.getBillingAddress();
        Assert.assertTrue(actualText.contains(address),"billing address mismatch");

    }

    @Then("user clicks delete account and success message is shown , user clicks on continue")
    public void userClicksDeleteAccountAndSuccessMessageIsShownUserClicksOnContinue() {
        deletePage = cartPage.clickOnDeleteAccountLink();
        String actualText = deletePage.getDeleteSuccessMessage();
        String expectedResult = "ACCOUNT DELETED!";
        Assert.assertTrue(actualText.contains(expectedResult),"delete message mismatch");
    }
}
