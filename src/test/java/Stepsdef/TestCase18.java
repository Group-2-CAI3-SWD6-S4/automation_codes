package Stepsdef;

import Pages.CategoryPage;
import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCase18 {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    CategoryPage categoryPage;

    @Given("user opens home page and clicks on women category under categories")
    public void user_opens_home_page_and_clicks_on_women_category_under_categories() {
        boolean isHomeVisible = homePage.verifyHomePage();
        Assert.assertTrue(isHomeVisible, "Home page is not visible!");

        String actualText = homePage.getCategorySideBar();
        String expectedText = "CATEGORY";
        Assert.assertTrue(actualText.contains(expectedText),"category text mismatch");


    }

    @When("user clicks on any category link under women, that category page is displayed")
    public void userClicksOnAnyCategoryLinkUnderWomenThatCategoryPageIsDisplayed() {
        homePage.clickWomenCategory();
        categoryPage = homePage.clickDressSubcategory();
        String actualText = categoryPage.getCategoryText();
        String expectedText = "WOMEN - DRESS PRODUCTS";
        Assert.assertTrue(actualText.contains(expectedText),"women Subcategory text mismatch");
    }

    @Then("user clicks on subcategory link men category and the user is navigated to that page")
    public void userClicksOnSubcategoryLinkMenCategoryAndTheUserIsNavigatedToThatPage() {
        categoryPage.clickMenCategory();
        categoryPage.clickMenTshirtsSubcategory();
        String actualText = categoryPage.getMenCategoryTitle();
        String expectedText = "MEN - TSHIRTS PRODUCTS";
        Assert.assertTrue(actualText.contains(expectedText),"men Subcategory text mismatch");
    }
}
