package avito.pageObject;

import avito.appConfig.BaseConfigTest;
import avito.appConfig.BaseLogicPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MainPage extends BaseLogicPage<MainPage> {
    private final WebDriverWait wait;

    public MainPage(WebDriver webDriver) {
        super(webDriver); // Важно: передаём драйвер в родительский класс
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    int sequenceNumber;

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

    //Кнопки категорий
    private By cardAutoPageElement = By.xpath("//*[contains(@data-marker, 'image-Авто')]");


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



    public void actionStepBefore() {
        try {
            click(beforeButton);
            click(goodButton);
            //click(leaveThisButtton);
            click(yesButton);
            click(closeInfoButton);
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
            try {
                WebElement likeButton = webDriver.findElement(likeInCardButton);
                wait.until(ExpectedConditions.visibilityOf(likeButton));
                likeButton.click();

                if (isLikeActive(likeInCardButton)) {
                    System.out.println("[INFO] Лайк успешно поставлен на карточке " + i);
                } else {
                    System.out.println("[WARN] Лайк не активирован на карточке " + i);
                }
            } catch (Exception e) {
                System.out.println("[ERROR] Не удалось поставить лайк на карточке " + i + ": " + e.getMessage());
            }
        }
    }

    public boolean isLikeActive(By likeButtonLocator) {
        try {
            WebElement likeElement = webDriver.findElement(likeButtonLocator);
            String state = likeElement.getAttribute("data-state");
            return "active".equals(state);
        } catch (NoSuchElementException e) {
            System.out.println("[WARN] Элемент лайка не найден: " + likeButtonLocator);
            return false;
        } catch (Exception e) {
            System.out.println("[ERROR] Ошибка проверки состояния лайка: " + e.getMessage());
            return false;
        }
    }

    public void scrollToElement(By elementLocator) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(elementLocator)).perform();
    }

}
