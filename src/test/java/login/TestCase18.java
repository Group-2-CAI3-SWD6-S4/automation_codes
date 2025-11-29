package login;

import Base.BaseTest;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase18 extends BaseTest {
    @Test
    public void Test(){
        //verify homepage is displayed
        boolean isHomeVisible = homePage.verifyHomePage();
        Assert.assertTrue(isHomeVisible, "Home page is not visible!");

        //verify category sideBar
        String actualText = homePage.getCategorySideBar();
        String expectedText = "CATEGORY";
        Assert.assertTrue(actualText.contains(expectedText),"category text mismatch");

        //click on women category
        homePage.clickWomenCategory();
        CategoryPage categoryPage = homePage.clickDressSubcategory();
        actualText = categoryPage.getCategoryText();
        expectedText = "WOMEN - DRESS PRODUCTS";
        Assert.assertTrue(actualText.contains(expectedText),"women Subcategory text mismatch");

        //click on men category
        categoryPage.clickMenCategory();
        categoryPage.clickMenTshirtsSubcategory();
        actualText = categoryPage.getMenCategoryTitle();
        expectedText = "MEN - TSHIRTS PRODUCTS";
        Assert.assertTrue(actualText.contains(expectedText),"men Subcategory text mismatch");


    }
}
