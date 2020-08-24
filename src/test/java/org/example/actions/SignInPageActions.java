package org.example.actions;

import org.example.pages.SignInPage;

import static org.example.ThreadObjects.pages;

public class SignInPageActions extends SignInPage {

    public SignInPageActions enterEmailAndPassword(String email, String password) {
        pages().signInPage()
                .enterEmailSignInForm(email)
                .enterPassword(password);
        return this;
    }
}
