package org.example.pages;

import org.example.actions.SignInPageActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.example.ThreadObjects.pages;

public class SignInPage {

    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    private WebElement emailFieldSignInForm;

    @FindBy(how = How.XPATH, using = "//input[@id='passwd']")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger']//ol/li")
    private WebElement errorMessage;

    private SignInPageActions signInPageActions;

    public SignInPageActions actions() {
        if (signInPageActions == null) {
            signInPageActions = new SignInPageActions();
        }
        return signInPageActions;
    }

    public SignInPage enterEmailSignInForm(String email) {
        emailFieldSignInForm.sendKeys(email);
        return pages().signInPage();
    }

    public SignInPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return pages().signInPage();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public void clickSignInButton() {
        pages().baseActions()
                .clickSpanButton("Sign in");
    }
}
