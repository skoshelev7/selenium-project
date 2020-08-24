package org.example;

import org.example.pages.LayerCartForm;
import org.example.pages.MainPage;
import org.example.pages.SearchPage;
import org.example.pages.SignInPage;
import org.openqa.selenium.support.PageFactory;

public class Pages {

    private MainPage mainPage;
    private SearchPage searchPage;
    private LayerCartForm layerCartForm;
    private SignInPage signInPage;

    public MainPage mainPage() {
        if (mainPage == null) {
            mainPage = PageFactory.initElements(WebDriverRunner.getWebDriver(), MainPage.class);
        }

        return mainPage;
    }

    public SearchPage searchPage() {
        if (searchPage == null) {
            searchPage = PageFactory.initElements(WebDriverRunner.getWebDriver(), SearchPage.class);
        }

        return searchPage;
    }

    public LayerCartForm layerCartForm() {
        if (layerCartForm == null) {
            layerCartForm = PageFactory.initElements(WebDriverRunner.getWebDriver(), LayerCartForm.class);
        }

        return layerCartForm;
    }

    public SignInPage signInPage() {
        if (signInPage == null) {
            signInPage = PageFactory.initElements(WebDriverRunner.getWebDriver(), SignInPage.class);
        }

        return signInPage;
    }
}
