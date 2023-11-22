package ru.yandex.praktikum.order;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ForWhomIsTheScooterPage extends BasePage {

    // Поле ввода "Имя"
    private By firstNameField = By.xpath(".//*[@placeholder = '* Имя']");

    // Поле ввода "Фамилия"
    private By lastNameField = By.xpath(".//input[@placeholder = '* Фамилия']");

    // Поле ввода "Адрес"
    private By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");

    // Поле ввода "Станция метро"
    private By metroStationField = By.xpath(".//input[@placeholder = '* Станция метро']");

    // Поле ввода "Телефон"
    private By phoneNumberField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");

    // Кнопка "Далее"
    private By furtherButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");


    public ForWhomIsTheScooterPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterFirstName(String firstName) {
        webDriver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        webDriver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterAddress(String address) {
        webDriver.findElement(addressField).sendKeys(address);
    }

    public void enterMetroStation(String metroStation) {
        webDriver.findElement(metroStationField).sendKeys(metroStation, Keys.DOWN, Keys.ENTER);

    }

    public void enterPhoneNumber(String phoneNumber) {
        webDriver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void clickFurtherButton() {
        webDriver.findElement(furtherButton).click();
    }

    public void fillTheFieldsForWhomIsTheScooterPage(String firstName, String lastName, String address, String metroStation, String phoneNumber) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterAddress(address);
        enterMetroStation(metroStation);
        enterPhoneNumber(phoneNumber);

    }

}
