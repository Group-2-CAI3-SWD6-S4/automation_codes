package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    //locators
    private By emailBox = By.cssSelector("input[data-qa='login-email']");
    private By passwordBox = By.cssSelector("input[data-qa='login-password']");
    private By loginButton = By.cssSelector("button[data-qa='login-button']");
    private By nameBox = By.cssSelector("input[data-qa='signup-name']");
    private By signupEmailBox = By.cssSelector("input[data-qa='signup-email']");
    private By signupButton = By.cssSelector("button[data-qa='signup-button']");

    //actions
    public void insertEmail(String email){
        driver.findElement(emailBox).sendKeys(email);
    }
    public void insertPassword(String password){
        driver.findElement(passwordBox).sendKeys(password);
    }
    public HomePage clickOnloginButton(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
    public void insertName(String name){
        driver.findElement(nameBox).sendKeys(name);
    }
    public void insertSignupEmail(String email){
        driver.findElement(signupEmailBox).sendKeys(email);
    }
    public SignupPage clickOnSignupButton(){
        driver.findElement(signupButton).click();
        return new SignupPage(driver);
    }
}
