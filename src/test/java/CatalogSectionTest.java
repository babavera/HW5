import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CatalogSectionTest {

    private final static By CATALOG = By.xpath("//ul[@class='b-main-navigation']//span[text()='Каталог']");

    private final static By ELECTRONICS = By.xpath("//li//span[text()='Электроника']");
    private final static By COMPUTERS_AND_NETWORKS = By.xpath("//li//span[contains(text(),'Компьютеры') and contains(text(),'сети')]");
    private final static By APPLIANCES = By.xpath("//li//span[contains(text(),'Бытовая техника')]");
    private final static By CONSTRUCTION_AND_REPAIR = By.xpath("//li//span[contains(text(),'Стройка') and contains(text(),'ремонт')]");
    private final static By HOUSE_AND_GARDEN = By.xpath("//li//span[contains(text(),'Дом') and contains(text(),'сад')]");
    private final static By AUTO_AND_MOTO = By.xpath("//li//span[contains(text(),'Авто') and contains(text(),'мото')]");
    private final static By BEAUTY_AND_SPORT = By.xpath("//li//span[contains(text(),'Красота') and contains(text(),'спорт')]");
    private final static By CHILDREN_AND_MOTHERS = By.xpath("//li//span[contains(text(),'Детям') and contains(text(),'мамам')]");
    private final static By WORK_AND_OFFICE = By.xpath("//li//span[contains(text(),'Работа ') and contains(text(),'офис')]");
    private final static By FOOD = By.xpath("//li//span[contains(text(),'Еда')]");

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
    public void testCatalogSection() {

        HomePage homePage = new HomePage(driver);
        ResultPage resultPage = homePage.resultPage(CATALOG);
        Assertions.assertAll("Should check for the presence of elements on the page",
                () -> Assertions.assertEquals(resultPage.getElementText(ELECTRONICS), "Электроника"),
                () -> Assertions.assertEquals(resultPage.getElementText(COMPUTERS_AND_NETWORKS), "Компьютеры и сети"),
                () -> Assertions.assertEquals(resultPage.getElementText(APPLIANCES), "Бытовая техника"),
                () -> Assertions.assertEquals(resultPage.getElementText(CONSTRUCTION_AND_REPAIR), "Стройка и ремонт"),
                () -> Assertions.assertEquals(resultPage.getElementText(HOUSE_AND_GARDEN), "Дом и сад"),
                () -> Assertions.assertEquals(resultPage.getElementText(AUTO_AND_MOTO), "Авто и мото"),
                () -> Assertions.assertEquals(resultPage.getElementText(BEAUTY_AND_SPORT), "Красота и спорт"),
                () -> Assertions.assertEquals(resultPage.getElementText(CHILDREN_AND_MOTHERS), "Детям и мамам"),
                () -> Assertions.assertEquals(resultPage.getElementText(WORK_AND_OFFICE), "Работа и офис"),
                () -> Assertions.assertEquals(resultPage.getElementText(FOOD), "Еда")
        );
    }
}
