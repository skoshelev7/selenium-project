package org.example.helpers;

import org.example.configs.Parameters;
import org.example.enums.Condition;
import org.example.enums.PagesEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

import static org.example.ThreadObjects.webDriverRunner;

public class Utils {

    private static WebDriverWait webDriverWait;
    private static HashMap<String, String> pages;

    static {
        webDriverWait = new WebDriverWait(webDriverRunner().getWebDriver(), Parameters.TIME_OUT);
        pages = new HashMap<String, String>() {{
            put("Main page", "http://automationpractice.com/index.php");
            put("Search page", "controller=search");
            put("Sign in page", "controller=authentication");
            put("My account page", "controller=my-account");
        }};
    }

    public static WebElement elementShouldBe(Condition condition, Object element) {
        if (!(element instanceof By || element instanceof WebElement)) {
            throw new IllegalArgumentException("Передан некорректный параметр element");
        }

        ExpectedCondition<WebElement> elementExpectedCondition = null;

        switch (condition) {
            case CLICKABLE:
                if (element instanceof By) {
                    elementExpectedCondition = ExpectedConditions.elementToBeClickable((By) element);
                }
                break;
            case VISIBLE:
                if (element instanceof By) {
                    elementExpectedCondition = ExpectedConditions.visibilityOfElementLocated((By)element);
                }
                else {
                    elementExpectedCondition = ExpectedConditions.visibilityOf((WebElement)element);
                }

                break;
        }

        assert elementExpectedCondition != null : "Ошибка: elementExpectedCondition is null";
        return webDriverWait.until(elementExpectedCondition);
    }

    public static boolean pageIsOpened(PagesEnum pagesEnum) {
        String currentPage = webDriverRunner().getWebDriver().getCurrentUrl();
        for (Map.Entry<String, String> pair : pages.entrySet()) {
            if (pair.getKey().equals(pagesEnum.getName())) {
                String value = pair.getValue();
                if (currentPage.contains(value)) {
                    return true;
                }
            }
        }
        throw new IllegalArgumentException("Страница не найдена");
    }
}
