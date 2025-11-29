package Base;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;


public class BaseTest {
    public WebDriver driver;
    public HomePage homePage;
    public WebDriverWait wait;
    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.edge.driver", "C:\\WebDriver\\msedgedriver.exe");
//        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        homePage = new HomePage(driver);
        goHome();
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://automationexercise.com/");
    }
    @AfterClass
    public void closeBrowser(){
       driver.quit();
    }
}
