package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {
    WebDriver driver;
    Select select;
    public SignupPage(WebDriver driver) {
        this.driver=driver;
    }

    //locators
    private By passwordBox = By.cssSelector("input[data-qa='password']");
    private By daysDropDown = By.id("days");
    private By monthDropDown = By.id("months");
    private By yearDromDown = By.id("years");
    private By firstNameBox = By.cssSelector("input[data-qa='first_name']");
    private By lastNameBox = By.cssSelector("input[data-qa='last_name']");
    private By addressBox = By.cssSelector("input[data-qa='address']");
    private By countryDropDown = By.id("country");
    private By stateBox = By.cssSelector("input[data-qa='state']");
    private By cityBox = By.cssSelector("input[data-qa='city']");
    private By zipCodeBox = By.cssSelector("input[data-qa='zipcode']");
    private By mobileNumberBox = By.cssSelector("input[data-qa='mobile_number']");
    private By createAccountButton = By.cssSelector("button[data-qa='create-account']");


    //Actions
    public void insertPassword(String password){
        driver.findElement(passwordBox).sendKeys(password);
    }
    public void selectDay(String text){
        select = new Select(driver.findElement(daysDropDown));
        select.selectByVisibleText(text);
    }
    public void selectMonth(String text){
        select = new Select(driver.findElement(monthDropDown));
        select.selectByVisibleText(text);
    }
    public void selectYear(String text){
        select = new Select(driver.findElement(yearDromDown));
        select.selectByVisibleText(text);
    }
    public void insertFirstName(String name){
        driver.findElement(firstNameBox).sendKeys(name);
    }
    public void insertLastName(String name){
        driver.findElement(lastNameBox).sendKeys(name);
    }
    public void insertAddress(String address){
        driver.findElement(addressBox).sendKeys(address);
    }
    public void selectCountry(String text){
        select = new Select(driver.findElement(countryDropDown));
        select.selectByVisibleText(text);
    }
    public void insertState(String state){
        driver.findElement(stateBox).sendKeys(state);
    }
    public void insertCity(String city){
        driver.findElement(cityBox).sendKeys(city);
    }
    public void insertZipCode(String code){
        driver.findElement(zipCodeBox).sendKeys(code);
    }
    public void insertMobileNumber(String number){
        driver.findElement(mobileNumberBox).sendKeys(number);
    }
    public AccountCreatedPage clickOnCreateAccountButton(){
        driver.findElement(createAccountButton).click();
        return new AccountCreatedPage(driver);
    }
}
