package Stepsdef;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCase5 {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage;

    @Given("User opens home page and press on signuplogin link")
    public void user_opens_home_page_and_press_on_signup_login_link() {
        homePage.verifyHomePage();
        loginPage = homePage.clickOnsignupLoginButton();
        String actualText = loginPage.getNewUserSignupText();
        String expectedText = "New User Signup!";
        Assert.assertTrue(actualText.contains(expectedText), "new user signup message mismatch");

    }

    @When("User enters valid email and password and click on signup button")
    public void userEntersValidEmailAndPasswordAndClickOnLoginButton() {
        loginPage.insertName("ash");
        loginPage.insertSignupEmail("ash123456@gmail.com");
        loginPage.clickOnSignupButton();
    }

    @Then("error message appears")
    public void homePageOpensWithLoggedInAsUsernameMessage() {
        String actualResult = loginPage.getEmailExistsErrorMessage();
        String expectedResult = "Email Address already exist!";
        Assert.assertTrue(actualResult.contains(expectedResult), "email already exist error message mismatch");
    }
}
