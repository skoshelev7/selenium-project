package org.example.tests;

import org.junit.*;

import static org.example.ThreadObjects.pages;
import static org.example.ThreadObjects.webDriverRunner;

public class SignInPageTests {

    @Before
    public void setUp() {
        pages().mainPage()
                .openPage()
                .clickSignInLink();
    }

    @Test
    public void incorrectEmailTest() {
        pages().signInPage().actions()
                .enterEmailAndPassword("email", "12345")
                .clickSignInButton();
        Assert.assertEquals("Invalid email address.", pages().signInPage().getErrorMessageText());
    }

    @Test
    public void emptyEmailTest() {
        pages().signInPage().actions()
                .enterEmailAndPassword("", "12345")
                .clickSignInButton();
        Assert.assertEquals("An email address required.", pages().signInPage().getErrorMessageText());
    }

    @Test
    public void incorrectPasswordTest() {
        pages().signInPage().actions()
                .enterEmailAndPassword("account123@test.com", "password")
                .clickSignInButton();
        Assert.assertEquals("Authentication failed.", pages().signInPage().getErrorMessageText());
    }

    @Test
    public void emptyPasswordTest() {
        pages().signInPage().actions()
                .enterEmailAndPassword("account123@test.com", "")
                .clickSignInButton();
        Assert.assertEquals("Password is required.", pages().signInPage().getErrorMessageText());
    }

    @AfterClass
    public static void afterClass() {
        webDriverRunner().close();
    }
}
