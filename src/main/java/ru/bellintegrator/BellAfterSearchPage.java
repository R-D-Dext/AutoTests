package ru.bellintegrator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BellAfterSearchPage extends  BellBeforeSearchPage {

    List<WebElement> listElements;

    BellAfterSearchPage(WebDriver chromeDriver) {
        super(chromeDriver);
    }

    public List<WebElement> resultSearch() {
        listElements = chromeDriver.findElements(By.xpath("//p[@class='search-result__snippet']"));
        System.out.println(listElements.size());
        return listElements;
    }
}
