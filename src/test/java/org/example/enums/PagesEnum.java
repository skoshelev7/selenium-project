package org.example.enums;

public enum PagesEnum {
    MAIN_PAGE("Main page"),
    SEARCH_PAGE("Search page"),
    SIGN_IN_PAGE("Sign in page"),
    MY_ACCOUNT("My account page");

    PagesEnum(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
