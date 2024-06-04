package ru.bellintegrator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tests extends BaseTest {

    @Test
    public void testTitle() {
        System.out.println("testTitle");
        chromeDriver.get("https://bellintegrator.ru/");
        String titleName = chromeDriver.getTitle();
        System.out.println(titleName);
        Assertions.assertTrue(titleName.contains("Bell Integrator"), "Тайтл не корректен");
    }

    @Test
    public void checkNews() {
        System.out.println("checkNews");
        chromeDriver.get("https://bellintegrator.ru/search/node?keys=");
        WebElement searchField = chromeDriver.findElement(By.id("edit-keys"));
        WebElement searchButton = chromeDriver.findElement(By.id("edit-submit"));
        searchField.sendKeys("RPA");
        searchButton.click();
        List<WebElement> resultSearch = chromeDriver.findElements(By.xpath("//p[@class='search-result__snippet']"));
        System.out.println(resultSearch.size());
        resultSearch.stream().forEach(x -> System.out.println(x.getText()));
    }

    @ParameterizedTest
    @CsvSource({"RPA, RPA", "Денис, Денис"})
    public void checkNewsPO(String keyWord, String result) {
        System.out.println("checkNewsPO");
        chromeDriver.get("https://bellintegrator.ru/search/node?keys=");
        BellBeforeSearchPage bellBeforeSearchPage = new BellBeforeSearchPage(chromeDriver);
        bellBeforeSearchPage.searchField(keyWord);
        BellAfterSearchPage bellAfterSearchPage = new BellAfterSearchPage(chromeDriver);
        List<WebElement> resultSearch = bellAfterSearchPage.resultSearch();
        resultSearch.stream().forEach(x -> System.out.println(x.getText()));
        Assertions.assertTrue(resultSearch.stream().anyMatch(x -> x.getText().contains(result)), "RPA нет");
    }
}