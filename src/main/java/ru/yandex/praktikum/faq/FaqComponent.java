package ru.yandex.praktikum.faq;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaqComponent extends BaseComponent {

    //локатор для вопроса
    private By questionLocator = By.xpath(".//div[contains(@id, 'accordion__heading')]");

    //локатор для ответа
    private By answerLocator = By.xpath(".//div[contains(@id, 'accordion__panel')]/p");

    public FaqComponent(WebElement root, WebDriver webDriver) {
        super(root, webDriver);
    }

    public String getQuestion() {
        return root.findElement(questionLocator).getText();
    }

    public String getAnswer() {
        return root.findElement(answerLocator).getText();
    }

    public void open() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait
                .until(ExpectedConditions.presenceOfElementLocated(questionLocator));
        WebElement questionElement = root.findElement(questionLocator);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", questionElement);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(questionElement));
        questionElement.click();

    }
}
