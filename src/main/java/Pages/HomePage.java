package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //locators
    private By signupLoginButton = By.cssSelector("a[href='/login']");
    private By productsLink = By.xpath("//a[@href='/products']");
    private By loggedinMessage = By.xpath("//a[contains(text(), 'Logged in')]");
    private By homePageTitle = By.xpath("//h2[contains(text(),'Full-Fledged')]");
    private By addProductToCart = By.cssSelector(".btn.btn-default.add-to-cart");
    private By productAddedMessage = By.xpath("//div[@class='modal-content']//p");
    private By viewCartButton = By.cssSelector("a[href='/view_cart']");
    private By categorySideBar = By.xpath("//h2[contains(text(),'Category')]");
    private By womenArrow = By.xpath("//a[normalize-space()='Women']/span/i");
    private By dressSubcategory = By.xpath("//a[normalize-space()='Dress']");
    private By contactUsLink = By.xpath("//a[@href='/contact_us']");
    private By testCasesPage = By.xpath("//a[contains(text(),'Test Cases')]");
    private By footerSection = By.xpath("//div[@class='footer-widget']");
    private By subscriptionHeader = By.xpath("//h2[normalize-space()='Subscription']");
    private By subscribeEmailInput = By.xpath("//input[@placeholder='Your email address']");
    private By subscribeButton = By.xpath("//button[@id='subscribe']");
    private By alertSuccessMessage = By.xpath("//div[@id='success-subscribe']//div[contains(@class,'alert-success')]");
    private By viewProductLink = By.xpath("//a[@href='/product_details/1' and contains(text(),'View Product')]");
    private By cartModal = By.id("cartModal");
    private By recommendedItemsHeader = By.cssSelector("h2.title.text-center");
    private By addRecommendedItemToCart = By.cssSelector("a.add-to-cart[data-product-id='4']");
    private By recommendedProductName = By.cssSelector(".recommended_items .productinfo p");
    private By deleteAccountLink = By.cssSelector("a[href='/delete_account']");
    private By scrollUpButton = By.id("scrollUp");
    private By homeText = By.xpath("//h2[contains(text(),'Full-Fledged practice website')]");





    //actions

    public LoginPage clickOnsignupLoginButton(){
        driver.findElement(signupLoginButton).click();
        return new LoginPage(driver);
    }
    public ProductsPage clickOnProductsLink(){
        driver.findElement(productsLink).click();
        return new ProductsPage(driver);
    }
    public String getLoggedinMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loggedinMessage)).getText();
    }
    public boolean verifyHomePage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageTitle));
        return driver.findElement(homePageTitle).isDisplayed();
    }
    public void hoverOverProduct(WebElement productElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(productElement).perform();
    }
    public void addProductToCart(){
        WebElement productButton = driver.findElement(addProductToCart);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productButton);
    }
//    public void addProductToCart(int productId) {
//        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.cssSelector("a[data-product-id='" + productId + "']"))
//        );
//
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", product);
//        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", product);
//
//        // Wait for the modal popup and click Continue Shopping
//        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
//                By.cssSelector(".btn-success.close-modal.btn-block"))
//        );
//        continueBtn.click();
//    }

    public String getProductAddedMessage() {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productAddedMessage));
        String message = messageElement.getText();

        WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCart);

        return message;
    }
    public CartPage clickOnViewCart(){
        wait.until(ExpectedConditions.elementToBeClickable(viewCartButton)).click();
        return new CartPage(driver);
    }
    public String getCategorySideBar(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(categorySideBar));
        return driver.findElement(categorySideBar).getText();
    }
    public void clickWomenCategory(){
        WebElement women = wait.until(ExpectedConditions.visibilityOfElementLocated(womenArrow));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 600);");
        wait.until(ExpectedConditions.elementToBeClickable(womenArrow));
        women.click();
    }
    public CategoryPage clickDressSubcategory(){
        WebElement dress = wait.until(ExpectedConditions.elementToBeClickable(dressSubcategory));
        dress.click();
        return new CategoryPage(driver);
    }
    public ContactUsPage clickOnContactUs(){
        driver.findElement(contactUsLink).click();
        return new ContactUsPage(driver);
    }
    public TestCasesPage clickOnTestCasesPage(){
        driver.findElement(testCasesPage).click();
        return new TestCasesPage(driver);
    }
    public void checkFooterSection(){
        WebElement footer = driver.findElement(footerSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
        wait.until(ExpectedConditions.visibilityOf(footer));

    }
    public boolean getSubscriptionHeader(){
        driver.findElement(subscriptionHeader).isDisplayed();
        return driver.findElement(subscriptionHeader).isDisplayed();
    }
    public void insertSubscribeEmailInput(String email){
        driver.findElement(subscribeEmailInput).sendKeys(email);
    }
    public void clickOnSubscribeButton(){
        driver.findElement(subscribeButton).click();
    }
    public String getAlertSuccessMessage(){
        String text = driver.findElement(alertSuccessMessage).getText();
        return text;
    }
    public ItemPage clickOnViewProductLink() {
        waitForCartModalToDisappear();
        driver.findElement(viewCartButton).click();
        return new ItemPage(driver);
    }
    public void waitForCartModalToDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(cartModal));
    }
    public void closeCartModalIfVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement closeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("#cartModal .close")));
            closeBtn.click();
        } catch (Exception e) {

        }

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-success.close-modal")));
//        continueButton.click();
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("cartModal")));
    }
    public String getRecommendedProductsHeader(){
        String text = driver.findElement(recommendedItemsHeader).getText();
        return text;
    }
    public void clickOnAddToCartRecommendedItem(){
        driver.findElement(addRecommendedItemToCart).click();
    }
    public String getRecommendedProductName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(recommendedProductName));
        return driver.findElement(recommendedProductName).getText();
    }
    public DeletePage clickOnDeleteAccountButton(){
        driver.findElement(deleteAccountLink).click();
        return new DeletePage(driver);
    }
    public void clickOnScrollUpButton(){
        driver.findElement(scrollUpButton).click();
    }
    public String getHomeText(){
        String text = driver.findElement(homeText).getText();
        return text;
    }
    public boolean scrollDownUntilSubscriptionVisible() {
        WebElement body = driver.findElement(By.tagName("body"));
        for (int i = 0; i < 20; i++) {
            body.sendKeys(Keys.ARROW_DOWN);
            if (this.getSubscriptionHeader()) {
                return true;
            }
        }
        return false;
    }
    public boolean scrollUPUntilFull_FelgedVisible() {
        WebElement body = driver.findElement(By.tagName("body"));
        for (int i = 0; i < 20; i++) {
            body.sendKeys(Keys.ARROW_UP);
            if (this.getSubscriptionHeader()) {
                return true;
            }
        }
        return false;
    }
}



