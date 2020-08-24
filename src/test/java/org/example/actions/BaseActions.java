package org.example.actions;

import org.example.configs.Parameters;
import org.example.WebDriverRunner;
import org.example.enums.Condition;
import org.example.helpers.Utils;
import org.openqa.selenium.By;

import static org.example.ThreadObjects.pages;

public class BaseActions {

    public static void openPage() {
        WebDriverRunner.getWebDriver().get(Parameters.BASE_URL);
    }

    public static void openPage(String url) {
        WebDriverRunner.getWebDriver().get(url);
    }

    public static void clickSpanButton(String buttonName) {
        By selector = By.xpath(String.format("//span/text()[contains(normalize-space(.), '%s')]/..", buttonName));

        Utils.elementShouldBe(Condition.CLICKABLE, selector).click();
    }

    public static void signIn(String email, String password) {
        pages().mainPage().clickSignInLink();
        pages().signInPage()
                .enterEmailSignInForm(email)
                .enterPassword(password)
                .clickSignInButton();
    }
}
