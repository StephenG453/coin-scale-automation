package stepDefinitions;

import cucumber.api.java.en.Given;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomePageStepDefinitions extends BaseTest {

    protected WebDriver driver;

    private BaseTest baseTest;

    private HomePage homePage;

    @Given("React Application is loaded and home page is visible")
    public void initializeDriverAndOpenReactApp() {
        baseTest = new BaseTest();
        baseTest.initialize();
        driver = baseTest.driver;

        homePage = new HomePage(driver);
//        Assertions.assertTrue(homePage.isAtHomePage());
    }
}
