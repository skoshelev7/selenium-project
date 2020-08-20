package org.example;

import org.example.pages.LayerCartForm;
import org.example.pages.MainPage;
import org.example.pages.SearchPage;
import org.example.pages.SignInPage;
import org.openqa.selenium.support.PageFactory;

public class Pages {

    private static MainPage mainPage;
    private static SearchPage searchPage;
    private static LayerCartForm layerCartForm;
    private static SignInPage signInPage;

    static {

    }

    public static MainPage mainPage() {
        if (mainPage == null) {
            mainPage = PageFactory.initElements(WebDriverRunner.getWebDriver(), MainPage.class);
        }

        return mainPage;
    }

    public static SearchPage searchPage() {
        if (searchPage == null) {
            searchPage = PageFactory.initElements(WebDriverRunner.getWebDriver(), SearchPage.class);
        }

        return searchPage;
    }

    public static LayerCartForm layerCartForm() {
        if (layerCartForm == null) {
            layerCartForm = PageFactory.initElements(WebDriverRunner.getWebDriver(), LayerCartForm.class);
        }

        return layerCartForm;
    }

    public static SignInPage signInPage() {
        if (signInPage == null) {
            signInPage = PageFactory.initElements(WebDriverRunner.getWebDriver(), SignInPage.class);
        }

        return signInPage;
    }
}
