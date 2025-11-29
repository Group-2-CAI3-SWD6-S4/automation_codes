package login;

import Base.BaseTest;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase19 extends BaseTest {
    @Test
    public void Test(){

        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage = homePage.clickOnProductsLink();

        //verify brands header
        String actualText = productsPage.getBrandsHeader();
        String expectedText = "BRANDS";
        Assert.assertTrue(actualText.contains(expectedText),"brands header text mismatch");

        //click on polo brand
        productsPage.clickOnPoloBrand();
        actualText = productsPage.getPoloHeader();
        expectedText = "BRAND - POLO PRODUCTS";
        Assert.assertTrue(actualText.contains(expectedText),"brands polo header mismatch");

        productsPage.clickHAndMBrandLink();
        actualText = productsPage.getHAndMHeader();
        expectedText = "BRAND - H&M PRODUCTS";
        Assert.assertTrue(actualText.contains(expectedText),"brand h&m header mismatch");



    }
}
