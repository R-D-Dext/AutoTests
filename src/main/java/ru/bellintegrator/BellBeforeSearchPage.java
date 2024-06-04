package ru.bellintegrator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BellBeforeSearchPage {
    protected WebDriver chromeDriver;
    private WebElement searchField;
    private WebElement searchButton;

    BellBeforeSearchPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        searchField = chromeDriver.findElement(By.id("edit-keys"));
        searchButton = chromeDriver.findElement(By.id("edit-submit"));
    }

    public void searchField(String stringField) {
        searchField.sendKeys(stringField);
        searchButton.click();
    }
}
