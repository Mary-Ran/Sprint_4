package ru.yandex.praktikum.order;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.StringContains.containsString;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrderAScooterTest {

    private WebDriver webDriver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @Test
    public void checkSuccessfulOrderUsingTheOrderButtonUp() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage homePage = new HomePage(webDriver);
        homePage.waitWhenOrderButtonUpToBeClickable();
        homePage.clickOrderButtonUp();

        ForWhomIsTheScooterPage forWhomIsTheScooterPage = new ForWhomIsTheScooterPage(webDriver);
        forWhomIsTheScooterPage.fillTheFieldsForWhomIsTheScooterPage("Анна", "Иванова", "г. Москва, Комсомольская пл. 6", "Комсомольская", "89123456789");
        forWhomIsTheScooterPage.clickFurtherButton();

        AboutRentPage aboutRentPage = new AboutRentPage(webDriver);
        aboutRentPage.fillTheFieldsAboutRentPage("25.11.2023");
        aboutRentPage.clickOrderButton();

        WantToPlaceAnOrderPage wantToPlaceAnOrderPage = new WantToPlaceAnOrderPage(webDriver);
        wantToPlaceAnOrderPage.clickYesButton();

        OrderCreatedPage orderCreatedPage = new OrderCreatedPage(webDriver);
        String title = orderCreatedPage.getTitleOrderDescription();

        MatcherAssert.assertThat(title, containsString("Заказ оформлен"));

    }


    @Test
    public void checkSuccessfulOrderUsingTheOrderButtonDown() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage homePage = new HomePage(webDriver);
        homePage.scrollThePageToTheOrderButtonDown();
        homePage.waitWhenOrderButtonDownToBeClickable();
        homePage.clickOrderButtonDown();

        ForWhomIsTheScooterPage forWhomIsTheScooterPage = new ForWhomIsTheScooterPage(webDriver);
        forWhomIsTheScooterPage.fillTheFieldsForWhomIsTheScooterPage("Мария", "Попова", "г. Москва, ул. Ленина, 1", "Сокольники", "89987654321");
        forWhomIsTheScooterPage.clickFurtherButton();

        AboutRentPage aboutRentPage = new AboutRentPage(webDriver);
        aboutRentPage.fillTheFieldsAboutRentPage("30.11.2023");
        aboutRentPage.clickOrderButton();

        WantToPlaceAnOrderPage wantToPlaceAnOrderPage = new WantToPlaceAnOrderPage(webDriver);
        wantToPlaceAnOrderPage.clickYesButton();

        OrderCreatedPage orderCreatedPage = new OrderCreatedPage(webDriver);
        String title = orderCreatedPage.getTitleOrderDescription();

        MatcherAssert.assertThat(title, containsString("Заказ оформлен"));

    }

    @After
    public void tearDown() {

        webDriver.quit();
    }
}
