package ru.yandex.praktikum.faq;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)

public class FaqTest {
    private WebDriver webDriver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @Parameterized.Parameter
    public int index;

    @Parameterized.Parameter(1)
    public String expectedQuestion;

    @Parameterized.Parameter(2)
    public String expectedAnswer;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {0, "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {3, "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {6, "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."}
        };
    }

    @Test
    public void faqTest() {
        HomePage mainPage = new HomePage(webDriver);
        mainPage.open();
        FaqComponent faqComponent = mainPage.getFaqComponent(index);
        faqComponent.open();
        Assert.assertEquals(expectedQuestion, faqComponent.getQuestion());
        Assert.assertEquals(expectedAnswer, faqComponent.getAnswer());

    }

    @After
    public void tearDown() {

        webDriver.quit();
    }
}
