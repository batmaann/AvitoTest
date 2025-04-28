package avito.appConfig;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseLogicPage<T> {

    protected WebDriver webDriver;
    protected T pageClassObj;

    public BaseLogicPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void BaseConfigTest() {
        this.pageClassObj = (T) this;
    }

    public T click(By elementLocator) {
        webDriver.findElement(elementLocator).click();
        return (T) this;
    }


}
