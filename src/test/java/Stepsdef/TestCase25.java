package Stepsdef;

import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCase25 {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("user opens home page, user scroll down page to bottom")
    public void user_opens_home_page_user_scroll_down_page_to_bottom() {
        boolean isHomeVisible = homePage.verifyHomePage();
        Assert.assertTrue(isHomeVisible, "Home page is not visible!");

//        homePage.getSubscriptionHeader();
        Assert.assertTrue(homePage.scrollDownUntilSubscriptionVisible());
        Assert.assertTrue(homePage.scrollUPUntilFull_FelgedVisible());

//        homePage.clickOnScrollUpButton();
//        String actualText = homePage.getHomeText();
//        String expectedText = "Full-Fledged practice website for Automation Engineers";
//        Assert.assertTrue(actualText.contains(expectedText),"home page text mismatch");



    }

    @When("user clicks on arrow at bottom right to move upward")
    public void userClicksOnArrowAtBottomRightToMoveUpward() {
    }


    @Then("page is scrolled up and Full-Fledged practice website for Automation Engineers text is visible on screenT")
    public void pageIsScrolledUpAndFullFledgedPracticeWebsiteForAutomationEngineersTextIsVisibleOnScreenT() {
    }
}
