package ru.bellintegrator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver chromeDriver;

    @BeforeEach
    public void before() {
        System.out.println("Before");
        chromeDriver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver", "C:\\tmp\\chrome.exe");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @AfterEach
    public void closeBellTest() {
        System.out.println("After");
        chromeDriver.quit();
    }
}
