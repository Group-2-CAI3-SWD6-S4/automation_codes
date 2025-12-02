package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    WebDriver driver;
    public ContactUsPage(WebDriver driver) {
        this.driver=driver;
    }

    //Locators
    private By getInTouchText = By.xpath("//h2[contains(text(),'Get In Touch')]");
    private By nameBox = By.cssSelector("input[data-qa='name']");
    private By EmailBox = By.cssSelector("input[data-qa='email']");
    private By subjectBox = By.cssSelector("input[data-qa='subject']");
    private By messageBox = By.cssSelector("textarea[data-qa='message']");
    private By uploadFileBox = By.cssSelector("input[name='upload_file']");
    private By submitButton = By.cssSelector("input[data-qa='submit-button']");
    private By successMessage = By.cssSelector("div.status.alert.alert-success");
    private By homeSuccessButton = By.xpath("//a[contains(., 'Home')]");



    //Actions
    public String getInTouchText(){
        String Text = driver.findElement(getInTouchText).getText();
        return Text;
    }
    public void insertName(String name){
        driver.findElement(nameBox).sendKeys(name);
    }
    public void insertEmail(String email){
        driver.findElement(EmailBox).sendKeys(email);
    }
    public void insertSubject(String subject){
        driver.findElement(subjectBox).sendKeys(subject);
    }
    public void insertMessage(String message){
        driver.findElement(messageBox).sendKeys(message);
    }
    public void uploadFile(String path){
        driver.findElement(uploadFileBox).sendKeys(path);
    }
    public void clickOnSubmitButton(){
        driver.findElement(submitButton).click();
    }
    public String getSuccessMessage(){
        String message = driver.findElement(successMessage).getText();
        return message;
    }
    public HomePage clickOnHomeSuccessbutton(){
        driver.findElement(homeSuccessButton).click();
        return new HomePage(driver);
    }
}
