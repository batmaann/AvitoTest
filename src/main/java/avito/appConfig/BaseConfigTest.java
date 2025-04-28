package avito.appConfig;


import avito.pageObject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class BaseConfigTest {
    protected WebDriver driver;
    protected MainPage mainPage;
    protected Actions actions;

    protected final String base_URL = "https://avito.ru"; // если у тебя где-то была base_URL переменная

    @Before
    public void setupDriver() {
        System.setProperty("webdriver.gecko.driver", "/Users/prime/MK/Education/AvitoTest/drivers/geckodriver");
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        actions = new Actions(driver);

        driver.get(base_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage.actionStepBefore();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
