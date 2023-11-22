package ru.yandex.praktikum.order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderCreatedPage extends BasePage {

    // Заголовок "Заказ оформлен" в всплывающем окне
    private By orderCreatedDescription = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ']");

    public OrderCreatedPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTitleOrderDescription() {
        return webDriver.findElement(orderCreatedDescription).getText();
    }

}

