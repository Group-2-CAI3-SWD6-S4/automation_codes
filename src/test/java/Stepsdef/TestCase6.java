package Stepsdef;

import Pages.ContactUsPage;
import Pages.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCase6 {
    WebDriver driver;
    HomePage homePage;
    ContactUsPage contactUsPage;

    @Before
    public void setUp() {
        driver = Hooks.getDriver();
        homePage = new HomePage(driver);
        contactUsPage = new ContactUsPage(driver);
    }

    @Given("User opens home page and clicks on contact us")
    public void user_opens_home_page_and_clicks_on_contact_us() {
        //verify homepage
        homePage.verifyHomePage();
        //click on contact us
        this.contactUsPage = homePage.clickOnContactUs();
        //verify get in touch is visable
        String actualText = contactUsPage.getInTouchText();
        String expectedText = "GET IN TOUCH";
        Assert.assertTrue(actualText.contains(expectedText),"get in touch message mismatch");

    }

    @When("User enters name, name, email, subject and message, uploads file, clicks on submit button, and OK")
    public void userEntersNameNameEmailSubjectAndMessageUploadsFileClicksOnSubmitButtonAndOK() {
        //enter name, email, subject and message
        contactUsPage.insertName("ash");
        contactUsPage.insertEmail("ash123456@gmail.com");
        contactUsPage.insertSubject("subject name");
        contactUsPage.insertMessage("message");
        String filePath = "C:\\Users\\ayadi\\Downloads\\uploaded file.txt";
        contactUsPage.uploadFile(filePath);
        contactUsPage.clickOnSubmitButton();

        //pop up
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();

    }

    @Then("Success message appears ,lands in homepage when clicking home button")
    public void successMessageAppearsLandsInHomepageWhenClickingHomeButton() {
        String actualMessage = contactUsPage.getSuccessMessage();
        String expectedMessage = "Success! Your details have been submitted successfully.";
        Assert.assertTrue(actualMessage.contains(expectedMessage),"details submitted message mismatch");
        contactUsPage.clickOnHomeSuccessbutton();
        homePage.verifyHomePage();
    }
}
