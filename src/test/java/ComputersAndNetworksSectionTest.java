import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ComputersAndNetworksSectionTest {

    private final static By CATALOG = By.xpath("//ul[@class='b-main-navigation']//span[text()='Каталог']");
    private final static By COMPUTERS_AND_NETWORKS = By.xpath("//li//span[contains(text(),'Компьютеры') and contains(text(),'сети')]");
    private final static By NOTEBOOKS_AND_COMPUTER = By.xpath("//div[contains(@class,'list__aside-item')][div[contains(text(),'Ноутбуки')]]");
    private final static By ACCESSORIES = By.xpath("//div[contains(@class,'list__aside-item')][div[contains(text(),'Комплектующие')]]");
    private final static By DATA_STORAGE = By.xpath("//div[contains(@class,'list__aside-item')][div[contains(text(),'Хранение данных')]]");
    private final static By NETWORK_HARDWARE = By.xpath("//div[contains(@class,'list__aside-item')][div[contains(text(),'Сетевое оборудование')]]");


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
    public void testComputersAndNetworkSection() {

        HomePage homePage = new HomePage(driver);
        ResultPage resultPage = homePage.resultPage(CATALOG);
        resultPage.clickOnElement(COMPUTERS_AND_NETWORKS);

        Assertions.assertAll(
                () -> Assertions.assertTrue(resultPage.findElementOnPage(NOTEBOOKS_AND_COMPUTER).isDisplayed()),
                () -> Assertions.assertTrue(resultPage.findElementOnPage(ACCESSORIES).isDisplayed()),
                () -> Assertions.assertTrue(resultPage.findElementOnPage(DATA_STORAGE).isDisplayed()),
                () -> Assertions.assertTrue(resultPage.findElementOnPage(NETWORK_HARDWARE).isDisplayed())
        );
    }
}


