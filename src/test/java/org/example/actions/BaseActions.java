package org.example.actions;

import org.example.enums.Condition;
import org.example.helpers.Utils;
import org.openqa.selenium.By;

import static org.example.ThreadObjects.pages;

public class BaseActions {

    public void clickSpanButton(String buttonName) {
        By selector = By.xpath(String.format("//span/text()[contains(normalize-space(.), '%s')]/..", buttonName));

        Utils.elementShouldBe(Condition.CLICKABLE, selector).click();
    }

    public void signIn(String email, String password) {
        pages().mainPage()
                .clickSignInLink();
        pages().signInPage()
                .enterEmailSignInForm(email)
                .enterPassword(password)
                .clickSignInButton();
    }
}
