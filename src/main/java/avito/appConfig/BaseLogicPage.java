package avito.appConfig;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseLogicPage<T> {

    WebDriver webDriver;
    protected T pageClassObj;

    public void BaseConfigTest() {
        this.pageClassObj = (T) this;
    }

    public T clickElement(By elementLocator) {
        webDriver.findElement(elementLocator).click();
        return (T) this;
    }


}
