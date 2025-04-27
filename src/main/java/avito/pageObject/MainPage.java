package avito.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MainPage {
    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    int sequenceNumber;

    WebDriver webDriver;
    //локаторы

    //локаторы before
    private By goodButton = By.xpath("//button[span/span[text()='Хорошо']]");
    private By leaveThisButtton = By.xpath("//button[span[text()='Оставить так']]");
    private By beforeButton = By.xpath("//button[span/span[text()='Наконец-то']]");
    private By yesButton = By.xpath("//button[span[text()='Да']]");
    private By closeInfoButton = By.xpath("//span[contains(@class, 'top-banner-module-cross')]");


    //Other
    private By categoriesButto = By.className("top-rubricator-newWrapper-VLDwY");
    private By categoriesButton = By.xpath("//*[@class=\"top-rubricator-buttonText-c0xFa\"]");
    private By chocieButton = By.xpath("//*[@data-marker=\"location/tooltip-agree\"]");
    private By realtyСategoryButton = By.xpath("//div[5][@class='new-rubricator-content-rootCategory-S2VPI']");
    private By likeButton = By.xpath("//div[@data-marker='favorite']");
    private By likeInCardButton = By.xpath("//div[contains(@class, 'styles-item-')][" + sequenceNumber + "]//*[@data-marker='favorite']");
    private By cardOnTheMainPage = By.xpath("//div[contains(@class, 'styles-item-')]");

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
            clickElement(leaveThisButtton);
            clickElement(goodButton);
            clickElement(yesButton);
            clickElement(closeInfoButton);
        } catch (Exception e) {
            System.out.println("[WARN] Не удалось закрыть всплывающие окно: " + e.getMessage());
        }
    }

    public void withLocator(Consumer<By> action) {
        action.accept(beforeButton); // Передаём приватный локатор в лямбду
    }

    public void clickLikeButton() {
        webDriver.findElement(likeButton).click();
    }


    public void clickLikeOnCards(int countLikes) {
        for (int i = 1; i <= countLikes; i++) {
            By likeInCardButton = By.xpath("//div[contains(@class, 'styles-item-')][" + i + "]//*[@data-marker='favorite']");
            clickElement(likeInCardButton);
        }
    }

    public void clickLikeOnCards1(int countLikes) {
        for (int i = 1; i <= countLikes; i++) {
            By likeInCardButton = By.xpath("//div[contains(@class, 'styles-item-')][" + i + "]//*[@data-marker='favorite']");

            boolean isClicked = false;
            int attempts = 0;

            while (!isClicked && attempts < 5) { // максимум 5 попыток на каждый элемент
                try {
                    clickElement(likeInCardButton); // Пытаемся кликнуть
                    isClicked = true; // Успех - выходим
                } catch (NoSuchElementException e) {
                    System.out.println("[INFO] Элемент " + i + " не найден, скроллим к нему...");
                    scrollToElement(likeInCardButton); // Скроллим к элементу
                    attempts++;
                }
            }

            if (!isClicked) {
                System.out.println("[WARN] Не удалось найти и кликнуть по элементу с номером " + i);
            }
        }
    }





    public void scrollToElement(By elementLocator) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(elementLocator)).perform();
    }



}





