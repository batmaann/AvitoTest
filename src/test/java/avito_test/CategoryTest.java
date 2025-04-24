package avito_test;

import avito.pageObject.MainPage;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Sleeper;


import java.io.File;
import java.time.Duration;

import static avito.appConfig.AppConfig.base_URL;
import static java.lang.Thread.sleep;

public class CategoryTest {
    WebDriver driver = new FirefoxDriver();
    MainPage mainPage = new MainPage(driver);
    Actions actions = new Actions(driver);

    @Before
    public void setupDriver() {
        System.setProperty("webdriver.gecko.driver", "/Users/prime/MK/Education/AvitoTest/drivers/geckodriver");
        driver.get(base_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        mainPage.actionStepBefore();
    }

    @Test
    @DisplayName("Проверка категория")
    @Description("null")
    public void choiceCategory() {

        mainPage.actionStepBefore();

        Sleeper sleeper = Sleeper.SYSTEM_SLEEPER;
        try {
            sleeper.sleep(Duration.ofSeconds(21)); // Работает в Selenium 4.3+
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Sleep interrupted", e);
        }

    }

    @After
    public void clean() {
        driver.quit();
    }
}
