package login;

import Base.BaseTest;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase16 extends BaseTest {
    @Test
    public void Test() {

        //steps
        LoginPage loginPage = homePage.clickOnsignupLoginButton();

        loginPage.insertEmail("ash123456@gmail.com");
        loginPage.insertPassword("ash123");
        HomePage homepage = loginPage.clickOnloginButton();


        //Assertions
        String actualResult = homepage.getLoggedinMessage();
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

        CartPage cartPage = homePage.clickOnViewCart();

        actualResult = cartPage.getShoppingCartText();
        expectedResult = "Shopping Cart";
        Assert.assertTrue(actualResult.contains(expectedResult), "cart message mismatch");

        cartPage.clickOnProceedToCheckOut();
        String actualText = cartPage.getAddressDetailsText();
        String ExpectedText = "Address Details";
        Assert.assertTrue(actualText.contains(ExpectedText));

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
        Assert.assertTrue(actualMessage.contains(expectedMessage), "payment message mismatch");

        DeletePage deletePage = paymentPage.clickDeleteAccount();
        String actualDeleteMessage = deletePage.getDeleteSuccessMessage();
        String expectedDeleteMessage = "ACCOUNT DELETED!";
        Assert.assertTrue(actualDeleteMessage.contains(expectedDeleteMessage), "delete message mismatch");

    }
}
