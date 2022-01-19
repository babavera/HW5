import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class ResultPage {

    private final WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getElementText(By xPath){
        return driver.findElement(xPath).getText();
    }

    public void clickOnElement(By xPath){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(xPath)).click();
    }

    public WebElement findElementOnPage(By xPath){
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(xPath));
    }

    public void moveToElementOnPage(By xPath){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(xPath)).perform();

    }

    public ArrayList<String> getListOfElementTexts(By elementsXPath){
        ArrayList<String> elementsTextList = new ArrayList<>();
        for (WebElement element : driver.findElements(elementsXPath)) {
            System.out.println(element.getText());
            System.out.println("______________");
            elementsTextList.add(element.getText());
        }
        return elementsTextList;
    }




}
