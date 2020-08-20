package org.example.actions;

import static org.example.Pages.mainPage;

public class MainPageActions {

    public static void enterSearchFieldAndClickSearchButton(String searchText) {
        mainPage()
                .enterSearchField(searchText)
                .clickSearchButton();
    }
}
