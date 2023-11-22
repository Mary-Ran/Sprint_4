package ru.yandex.praktikum.faq;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends BasePage {
    private final By faqItems = By.cssSelector(".accordion__item");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void open() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public FaqComponent getFaqComponent(int index) {
        WebElement webElement = webDriver.findElements(faqItems).get(index);
        return new FaqComponent(webElement, webDriver);

    }


}
