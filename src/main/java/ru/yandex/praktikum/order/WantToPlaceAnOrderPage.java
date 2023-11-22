package ru.yandex.praktikum.order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WantToPlaceAnOrderPage extends BasePage {

    // Кнопка "Да" в всплывающем окне "Хотите оформить заказ?"
    private By yesButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']");

    public WantToPlaceAnOrderPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickYesButton() {
        webDriver.findElement(yesButton).click();
    }

}