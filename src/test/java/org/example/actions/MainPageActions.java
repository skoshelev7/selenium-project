package org.example.actions;

import static org.example.ThreadObjects.pages;

public class MainPageActions {

    public void enterSearchFieldAndClickSearchButton(String searchText) {
        pages().mainPage()
                .enterSearchField(searchText)
                .clickSearchButton();
    }
}
