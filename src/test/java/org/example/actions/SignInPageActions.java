package org.example.actions;

import org.example.pages.SignInPage;

import static org.example.Pages.signInPage;

public class SignInPageActions extends SignInPage {

    public SignInPageActions enterEmailAndPassword(String email, String password) {
        signInPage()
                .enterEmailSignInForm(email)
                .enterPassword(password);
        return this;
    }
}
