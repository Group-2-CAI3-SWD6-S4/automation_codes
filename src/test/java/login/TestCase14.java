package login;

import Base.BaseTest;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase14 extends BaseTest {
    @Test
    public void Test(){

        //verify homepage is displayed
        boolean isHomeVisible = homePage.verifyHomePage();
        Assert.assertTrue(isHomeVisible, "Home page is not visible!");

        //add product to cart and proceed to checkout
        homePage.addProductToCart();
        String actualResult = homePage.getProductAddedMessage();
        String expectedResult = "Your product has been added to cart.";
        Assert.assertTrue(actualResult.contains(expectedResult),"product message mismatch");

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
        AccountCreatedPage accountCreatedPage = signupPage.clickOnCreateAccountButton();

        actualResult = accountCreatedPage.getAccountCreatedMessage();
        expectedResult = "ACCOUNT CREATED!";
        Assert.assertTrue(actualResult.contains(expectedResult),"account created message mismatch");

        //click contiue button and verify logged in as
        HomePage homePage = accountCreatedPage.clickOnContinueButton();
        actualResult = homePage.getLoggedinMessage();
        expectedResult = "Logged in as ";
        Assert.assertTrue(actualResult.contains(expectedResult), "Login success message mismatch.");

        homePage.clickOnViewCart();
        cartPage.clickOnProceedToCheckOut();

        String actualText =  cartPage.getAddressDetailsText();
        String ExpectedText = "Address Details";
        Assert.assertTrue(actualText.contains(ExpectedText),"address details mismatch");

        cartPage.insertCommentText("comment");

        PaymentPage paymentPage = cartPage.clickPlaceOrderButton();
        paymentPage.insertNameOnCard("ash");
        paymentPage.insertCardNumber("123456");
        paymentPage.insertCvcBox("311");
        paymentPage.insertExpiratonMonth("12");
        paymentPage.insertExpirationYear("2030");
        paymentPage.clickConfirmOrderButton();

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
