package Stepsdef;

import Pages.HomePage;
import Pages.TestCasesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCase7 {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    TestCasesPage testCasesPage;

    @Given("User opens home page")
    public void user_opens_home_page() {
        homePage.verifyHomePage();
    }

    @When("User clicks on test cases")
    public void userClicksOnTestCases() {
        testCasesPage = homePage.clickOnTestCasesPage();
    }

    @Then("test cases page appears")
    public void testCasesPageAppears() {
        String actualText = testCasesPage.getTestCasesHeader();
        String expectedText = "TEST CASES";
        Assert.assertTrue(actualText.contains(expectedText),"testcases page message mismatch");
    }
}
