package ru.yandex.praktikum.order;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AboutRentPage extends BasePage {

    // Поле ввода "Когда привезти самокат"
    private By whenToBringTheScooterField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    // Поле "Срок аренды"
    private By rentalPeriodField = By.xpath(".//div[text() = '* Срок аренды']");

    // Значение "сутки" в выпадающем списке поля "Срок аренды"
    private By rentalPeriodOneDay = By.xpath(".//div[text() = 'сутки']");

    // Кнопка "Заказать"
    private By orderButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    public AboutRentPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterWhenToBringTheScooter(String date) {
        webDriver.findElement(whenToBringTheScooterField).sendKeys(date, Keys.ENTER);
    }

    public void enterRentalPeriod() {
        webDriver.findElement(rentalPeriodField).click();
        webDriver.findElement(rentalPeriodOneDay).click();
    }

    public void clickOrderButton() {
        webDriver.findElement(orderButton).click();
    }


    public void fillTheFieldsAboutRentPage(String date) {
        enterWhenToBringTheScooter(date);
        enterRentalPeriod();
    }
}
