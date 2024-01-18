package avito.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

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


}





