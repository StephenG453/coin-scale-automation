package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[contains(text(),'Reset')]")
    private WebElement resetButton;

    @FindBy(id = "weigh")
    private WebElement weighButton;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[5]")
    private WebElement weighings;

//    @FindBy(id = "coin_0")
//    private WebElement coin0;
//
//    @FindBy(id = "coin_1")
//    private WebElement coin1;
//
//    @FindBy(id = "coin_2")
//    private WebElement coin2;
//
//    @FindBy(id = "coin_3")
//    private WebElement coin3;
//
//    @FindBy(id = "coin_4")
//    private WebElement coin4;
//
//    @FindBy(id = "coin_5")
//    private WebElement coin5;
//
//    @FindBy(id = "coin_6")
//    private WebElement coin6;
//
//    @FindBy(id = "coin_7")
//    private WebElement coin7;
//
//    @FindBy(id = "coin_8")
//    private WebElement coin8;
//
//    @FindBy(id = "left_0")
//    private WebElement left0;
//
//    @FindBy(id = "left_1")
//    private WebElement left1;
//
//    @FindBy(id = "left_2")
//    private WebElement left2;
//
//    @FindBy(id = "left_3")
//    private WebElement left3;
//
//    @FindBy(id = "left_4")
//    private WebElement left4;
//
//    @FindBy(id = "left_5")
//    private WebElement left5;
//
//    @FindBy(id = "left_6")
//    private WebElement left6;
//
//    @FindBy(id = "left_7")
//    private WebElement left7;
//
//    @FindBy(id = "left_8")
//    private WebElement left8;
//
//    @FindBy(id = "right_0")
//    private WebElement right0;
//
//    @FindBy(id = "right_1")
//    private WebElement right1;
//
//    @FindBy(id = "right_2")
//    private WebElement right2;
//
//    @FindBy(id = "right_3")
//    private WebElement right3;
//
//    @FindBy(id = "right_4")
//    private WebElement right4;
//
//    @FindBy(id = "right_5")
//    private WebElement right5;
//
//    @FindBy(id = "right_6")
//    private WebElement right6;
//
//    @FindBy(id = "right_7")
//    private WebElement right7;
//
//    @FindBy(id = "right_8")
//    private WebElement right8;

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
    }

    public void checkLatestWeighResult() {
        List<WebElement> list = weighings.findElements(By.tagName("li"));
        int count = list.size();

        //TODO: get latest once in the list
        for (WebElement element : list) {
            System.out.println(element.getText());
        }
        System.out.println(count);

    }
}
