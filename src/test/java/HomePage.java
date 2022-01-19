import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public ResultPage resultPage(By xPath){
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(xPath)).click();
    return new ResultPage(driver);
    }
}
