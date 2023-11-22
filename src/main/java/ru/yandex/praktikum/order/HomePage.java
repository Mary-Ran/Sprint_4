package ru.yandex.praktikum.order;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    // кнопка "Заказать" вверху страницы
    private By orderButtonUp = By.xpath(".//button[@class = 'Button_Button__ra12g']");

    // кнопка "Заказать" внизу страницы
    private By orderButtonDown = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOrderButtonUp() {
        webDriver.findElement(orderButtonUp).click();
    }

    public void clickOrderButtonDown() {
        webDriver.findElement(orderButtonDown).click();
    }

    public void waitWhenOrderButtonUpToBeClickable() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(orderButtonUp));
    }

    public void waitWhenOrderButtonDownToBeClickable() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(orderButtonDown));
    }

    public void scrollThePageToTheOrderButtonDown() {
        WebElement element = webDriver.findElement(orderButtonDown);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

}