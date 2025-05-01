package avito_test;

import avito.appConfig.BaseConfigTest;
import avito.pageObject.MainPage;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static avito.appConfig.AppConfig.base_URL;
import static java.lang.Thread.sleep;

public class MainPageTest extends BaseConfigTest {
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
    @DisplayName("Проверка лайков")
    @Description("Проставление n лайков на карточках гланой страницы")
    public void addFavoriteInMainTest() {
        mainPage.clickLikeOnCards(18);

    }

    //В работе
    @Test
    @DisplayName("Проверка страницы Авто")
    @Description("Переход на страницу раздела Авто, проверка, возврат назад")
    public void moveToPageAuto() {


    }


    //        Sleeper sleeper = Sleeper.SYSTEM_SLEEPER;
//        try {
//            sleeper.sleep(Duration.ofSeconds(5));
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            throw new RuntimeException("Sleep interrupted", e);
//        }
    @After
    public void clean() {
         driver.quit();
    }
}
