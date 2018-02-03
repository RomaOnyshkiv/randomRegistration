package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement localElement(By by) {
        return driver.findElement(by);
    }

    protected void typeText(By by, String text) {
        localElement(by).sendKeys(text);
    }

    protected void clickOn(By by) {
        localElement(by).click();
    }


}
