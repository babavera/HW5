import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class AvailabilityCheckTest {

    private final static By CATALOG = By.xpath("//ul[@class='b-main-navigation']//span[text()='Каталог']");
    private final static By COMPUTERS_AND_NETWORKS = By.xpath("//li//span[contains(text(),'Компьютеры') and contains(text(),'сети')]");
    private final static By ACCESSORIES = By.xpath("//div[contains(@class,'list__aside-item')][div[contains(text(),'Комплектующие')]]");
    private final static By ELEMENT_TITLE_IN_ACCESSORIES = By.xpath("//div[contains(@class,'list__aside-item')][div[contains(text(),'Комплектующие')]]//span[contains(@class,'dropdown-title')]");
    private final static By ELEMENT_DESCRIPTION_IN_ACCESSORIES = By.xpath("//div[contains(@class,'list__aside-item')][div[contains(text(),'Комплектующие')]]//span[contains(@class,'dropdown-description')]");

    private WebDriver driver;

    @BeforeEach
    public void setUp() {

        try {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://onliner.by");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   @AfterEach
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testAvailabilityCheck() {
        HomePage homePage = new HomePage(driver);
        ResultPage resultPage = homePage.resultPage(CATALOG);
        resultPage.clickOnElement(COMPUTERS_AND_NETWORKS);
        resultPage.clickOnElement(ACCESSORIES);

        for (String text : resultPage.getListOfElementTexts(ELEMENT_TITLE_IN_ACCESSORIES)) {
            Assertions.assertNotNull(text);
        }
        for (String text : resultPage.getListOfElementTexts(ELEMENT_DESCRIPTION_IN_ACCESSORIES)) {
            Assertions.assertNotNull(text);
        }
    }
}
