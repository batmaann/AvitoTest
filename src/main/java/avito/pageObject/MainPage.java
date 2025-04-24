package avito.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.function.Consumer;

public class MainPage {
    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    WebDriver webDriver;
    //локаторы
    private By categoriesButto = By.className("top-rubricator-newWrapper-VLDwY");
    private By categoriesButton = By.xpath("//*[@class=\"top-rubricator-buttonText-c0xFa\"]");
    private By chocieButton = By.xpath("//*[@data-marker=\"location/tooltip-agree\"]");
    private By realtyСategoryButton = By.xpath("//div[5][@class='new-rubricator-content-rootCategory-S2VPI']");
    private By beforeButton = By.xpath("//button[span/span[text()='Наконец-то']]");
    private By goodButton = By.xpath("//button[span/span[text()='Хорошо']]");
    private By yesButton = By.xpath("//button[span[text()='Да']]");
    private By closeInfoButton = By.xpath("//span[contains(@class, 'top-banner-module-cross')]");


    //методы
    public void clickСategoriesButton() {
        webDriver.findElement(categoriesButton).click();
    }

    public void clickСityButton() {
        webDriver.findElement(chocieButton).click();
    }

    public void choiceCategoryMove() {
        webDriver.findElement(realtyСategoryButton).click();
    }

    //кусов говвна
    public void clickElement(By elementLocator) {
        webDriver.findElement(elementLocator).click();
    }


    public void actionStepBefore() {
        try {
            clickElement(beforeButton);
        } catch (Exception e) {
            System.out.println("[WARN] Не удалось кликнуть beforeButton: " + e.getMessage());
        }
        try {
            clickElement(goodButton);
        } catch (Exception e) {
            System.out.println("[WARN] Не удалось кликнуть goodButton: " + e.getMessage());
        }
        try {
            clickElement(yesButton);
        } catch (Exception e) {
            System.out.println("[WARN] Не удалось кликнуть yesButton: " + e.getMessage());
        }
        try {
            clickElement(closeInfoButton);
        } catch (Exception e) {
            System.out.println("[WARN] Не удалось кликнуть closeInfoButton: " + e.getMessage());
        }
    }

    public void withLocator(Consumer<By> action) {
        action.accept(beforeButton); // Передаём приватный локатор в лямбду
    }


}





