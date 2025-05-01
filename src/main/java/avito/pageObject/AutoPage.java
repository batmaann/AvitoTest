package avito.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutoPage {
    public AutoPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    int sequenceNumber;

    WebDriver webDriver;
    //локаторы
    private By AutoElement = By.xpath("//*[contains(@title, 'Авито — сайт объявлений об автомобилях')]");

}
