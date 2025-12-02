package Stepsdef;

import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCase10 {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("user opens home page and scrolls to footer")
    public void user_opens_home_page_and_scrolls_to_footer() {
        homePage.verifyHomePage();
        homePage.checkFooterSection();
    }

    @When("user enters email address in input and click arrow button")
    public void userEntersEmailAddressInInputAndClickArrowButton() {
        homePage.getSubscriptionHeader();

        homePage.insertSubscribeEmailInput("ash123456@gmail.com");
        homePage.clickOnSubscribeButton();
    }

    @Then("Success message appears")
    public void successMessageAppears() {
        String actualText = homePage.getAlertSuccessMessage();
        String expectedText = "You have been successfully subscribed!";
        Assert.assertTrue(actualText.contains(expectedText),"subscription success message mismatch");
    }
}
