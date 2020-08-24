package org.example.tests;

import org.example.actions.BaseActions;
import org.example.actions.SignInPageActions;
import org.junit.*;

import static org.example.ThreadObjects.pages;
import static org.example.ThreadObjects.webDriverRunner;

public class SignInPageTests {

    SignInPageActions signInPageActions;

    @Before
    public void setUp() {
        signInPageActions = new SignInPageActions();

        BaseActions.openPage();
        pages().mainPage().clickSignInLink();
    }

    @Test
    public void incorrectEmailTest() {
        signInPageActions.enterEmailAndPassword("email", "password").clickSignInButton();
        Assert.assertEquals("Invalid email address.", pages().signInPage().getErrorMessageText());
    }

    @Test
    public void emptyEmailTest() {
        signInPageActions.enterEmailAndPassword("", "password").clickSignInButton();
        Assert.assertEquals("An email address required.", pages().signInPage().getErrorMessageText());
    }

    @Test
    public void incorrectPasswordTest() {
        signInPageActions.enterEmailAndPassword("account123@test.com", "password").clickSignInButton();
        Assert.assertEquals("Authentication failed.", pages().signInPage().getErrorMessageText());
    }

    @Test
    public void emptyPasswordTest() {
        signInPageActions.enterEmailAndPassword("account123@test.com", "").clickSignInButton();
        Assert.assertEquals("Password is required.", pages().signInPage().getErrorMessageText());
    }

    @AfterClass
    public static void afterClass() {
        webDriverRunner().close();
    }
}
