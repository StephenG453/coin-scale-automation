package stepDefinitions;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public HomePage homePage;

    public void initialize() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.MAC);
        chromeOptions.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        System.setProperty("webdriver.chrome.driver", "/Users/cbrat62/Desktop/Selenium/chromedriver");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
    }

    //    void waitForElementClickable(WebElement element) {
//        WebDriverWait wait = new WebDriverWait(driver, 15);
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//    }
//
//    void turnOffImplicitWait(){
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//    }
//
//    void turnOnImplicitWait(){
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }

    public void cleanUp() {
        driver.close();
        driver.quit();
    }
}
