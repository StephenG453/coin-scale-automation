package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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

    @When("coin 0 is added to first cell in the left grid")
    public void inputCoinZeroIntoLeftGrid() {
        homePage.insertCoinIntoLeftGrid(0,0);
    }

    @When("coin 1 is added to second cell in the left grid")
    public void inputCoinOneIntoLeftGrid() {
        homePage.insertCoinIntoLeftGrid(1,1);
    }

    @When("coin 2 is added to third cell in the left grid")
    public void inputCoinTwoIntoLeftGrid() {
        homePage.insertCoinIntoLeftGrid(2,2);
    }

    @When("coin 3 is added to first cell in the right grid")
    public void inputCoinThreeIntoRightGrid() {
        homePage.insertCoinIntoRightGrid(3,0);
    }

    @When("coin 4 is added to second cell in the right grid")
    public void inputCoinFourIntoRightGrid() {
        homePage.insertCoinIntoRightGrid(4,1);
    }

    @When("coin 5 is added to third cell in the right grid")
    public void inputCoinFiveIntoRightGrid() {
        homePage.insertCoinIntoRightGrid(5,2);
    }

    @When("weigh button is pressed")
    public void pressWeighButton() {
        homePage.pressWeighButton();
    }

    @When("latest weight result is checked")
    public void checkLatestWeightResult() {
        homePage.checkLatestWeighResult();
    }

    @When("right grid is cleared for round 2")
    public void clearRightGridForRound2() {
        homePage.manuallyClearGrid('r');
    }

    @When("coin 6 is added to first cell in the right grid")
    public void inputCoinSixIntoRightGrid() {
        homePage.insertCoinIntoRightGrid(6,0);
    }

    @When("coin 7 is added to second cell in the right grid")
    public void inputCoinSevenIntoRightGrid() {
        homePage.insertCoinIntoRightGrid(7,1);
    }

    @When("coin 8 is added to third cell in the right grid")
    public void inputCoinEightIntoRightGrid() {
        homePage.insertCoinIntoRightGrid(8,2);
    }

    @When("group with fake weight is determined")
    public void determineGroupWithFakeWeight() {
        homePage.determineGroupWithFakeWeight();
    }

    @Then("fake weight is found")
    public void locateFakeWeightWithinGroup() {
        homePage.locateFakeWeightWithinGroup();

        baseTest.cleanUp();
    }
}
