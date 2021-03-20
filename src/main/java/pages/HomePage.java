package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import sun.jvm.hotspot.memory.SystemDictionary;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[contains(text(),'Reset')]")
    private WebElement resetButton;

    @FindBy(id = "weigh")
    private WebElement weighButton;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[5]")
    private WebElement weighings;

    private boolean isRound1ResultEqual;
    private boolean isRound2ResultEqual;

    private boolean isFakeWeightInGroup1 = false;
    private boolean isFakeWeightInGroup2 = false;
    private boolean isFakeWeightInGroup3 = false;

    private int weighCount;

    private List<WebElement> list;

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get("http://ec2-54-208-152-154.compute-1.amazonaws.com/");
    }

    public void insertCoinIntoLeftGrid(int coin, int cell) {
        WebElement coinToAdd = driver.findElement(By.id("coin_" + coin));
        String coinText = coinToAdd.getText();
        WebElement cellToBeFilled = driver.findElement(By.id("left_" + cell));

        cellToBeFilled.sendKeys(coinText);
    }

    public void insertCoinIntoRightGrid(int coin, int cell) {
        WebElement coinToAdd = driver.findElement(By.id("coin_" + coin));
        String coinText = coinToAdd.getText();
        WebElement cellToBeFilled = driver.findElement(By.id("right_" + cell));

        cellToBeFilled.sendKeys(coinText);
    }

    public void pressWeighButton() {
        weighButton.click();
        weighCount++;
    }

    public void checkLatestWeighResult() {
        list = weighings.findElements(By.tagName("li"));

        //in round 1
        if (list.size() == 1) {
            WebElement latestWebElement = list.get(0);
            String latestWebElementText = latestWebElement.getText();

            isRound1ResultEqual = latestWebElementText.contains("=");
        }   // in round 2
        else if (list.size() == 2) {
            WebElement latestWebElement = list.get(1);
            String latestWebElementText = latestWebElement.getText();

            isRound2ResultEqual = latestWebElementText.contains("=");
        }
    }

    public void determineGroupWithFakeWeight() {
        if (isRound1ResultEqual) {
            if (isRound2ResultEqual) {
                isFakeWeightInGroup1 = true;
            } else {
                isFakeWeightInGroup3 = true;
            }
        } else {
            if (isRound2ResultEqual) {
                isFakeWeightInGroup2 = true;
            } else {
                isFakeWeightInGroup1 = true;
            }
        }
    }

    public void locateFakeWeightWithinGroup() {
        if (isFakeWeightInGroup1) {
            for (int i = 0; i < 3; i++) {
                driver.findElement(By.id("coin_" + i)).click();
                Alert alert = driver.switchTo().alert();
                System.out.println("Alert text is: " + alert.getText());

                if (alert.getText().contains("Yay!")) {
                    System.out.println("\nfake weight is coin " + i);
                    alert.accept();
                    break;
                }
                alert.accept();
            }
        } else if (isFakeWeightInGroup2) {
            for (int i = 3; i < 6; i++) {
                driver.findElement(By.id("coin_" + i)).click();
                Alert alert = driver.switchTo().alert();
                System.out.println("Alert text is: " + alert.getText());

                if (alert.getText().contains("Yay!")) {
                    System.out.println("\nfake weight is coin " + i);
                    alert.accept();
                    break;
                }
                alert.accept();
            }
        } else {
            for (int i = 6; i < 9; i++) {
                driver.findElement(By.id("coin_" + i)).click();
                Alert alert = driver.switchTo().alert();
                System.out.println("Alert text is: " + alert.getText());

                if (alert.getText().contains("Yay!")) {
                    System.out.println("\nfake weight is coin " + i);
                    alert.accept();
                    break;
                }
                alert.accept();
            }
        }
        printAuxiliaryInfo();
    }

    public void manuallyClearGrid(Character grid) {
        if (grid != 'l' && grid != 'r') {
            System.out.println("Please enter 'l' to clear left grid or 'r' to clear right grid. App will now close");
            driver.close();
        }

        if (grid == 'l') {
            for (int i = 0; i < 9; i++) {
                WebElement cellToBeCleared = driver.findElement(By.id("left_" + i));
                cellToBeCleared.sendKeys(Keys.BACK_SPACE);
            }
        } else {
            for (int i = 0; i < 9; i++) {
                WebElement cellToBeCleared = driver.findElement(By.id("right_" + i));
                cellToBeCleared.sendKeys(Keys.BACK_SPACE);
            }
        }
    }

    private void printAuxiliaryInfo() {
        System.out.println("\nNumber of total weighings made: " + weighCount);
        System.out.println("Weighing List:");
        for (WebElement element : list) {
            System.out.println(element.getText());
        }
    }
}
