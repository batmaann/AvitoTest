package avito_test;

import avito.pageObject.MainPage;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.time.Duration;

import static avito.appConfig.AppConfig.base_URL;

public class CategoryTest {
    WebDriver driver = new FirefoxDriver();
    MainPage mainPage = new MainPage(driver);
    Actions actions = new Actions(driver);

    @Before
    public void setupDriver() {
        System.setProperty("webdriver.gecko.driver", "/Users/prime/MK/Education/AvitoTest/drivers/geckodriver");
        driver.get(base_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try {
            mainPage.clickСityButton();
        } catch (NoSuchElementException e) {
            // Если кнопки нет, ловим исключение, но продолжаем выполнение теста
        }
    }

    @Test
    @DisplayName("Проверка категория")
    @Description("null")
    public void choiceCategory() {
        mainPage.clickСategoriesButton();
        //for (int i = 2; i < 5; i++) {
            mainPage.choiceCategoryMove();
        //}
    }

    @After
    public void clean() {
        driver.quit();
    }
}
