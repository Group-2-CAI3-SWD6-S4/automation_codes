package Stepsdef;

import Pages.CartPage;
import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCase11 {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    CartPage cartPage;

    @Given("user opens home page and clicks on cart button and scrolls down to footer")
    public void user_opens_home_page_and_clicks_on_cart_button_and_scrolls_down_to_footer() {
        homePage.verifyHomePage();
        cartPage = homePage.clickOnViewCart();
        cartPage.scrollToFooterSectionInCart();
    }

    @When("user enters email address in input and clicks arrow button")
    public void userEntersEmailAddressInInputAndClicksArrowButton() {
        String actualText = cartPage.getSubscriptionHeader();
        String expectedText = "SUBSCRIPTION";
        Assert.assertTrue(actualText.contains(expectedText),"subscription text mismatch");
        cartPage.insertSubscribeEmailInput("ash123456@gmail.com");
        cartPage.clickOnSubscribeButton();
    }

    @Then("success message appears to user")
    public void successMessageAppearsToUser() {
        String actualmessage = cartPage.getAlertSuccessMessage();
        String expectedMessage = "You have been successfully subscribed!";
        Assert.assertTrue(actualmessage.contains(expectedMessage),"success message mismatch");
    }
}
