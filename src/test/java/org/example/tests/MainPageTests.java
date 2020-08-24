package org.example.tests;

import org.example.configs.Parameters;
import org.example.helpers.Utils;
import org.example.actions.BaseActions;
import org.example.actions.MainPageActions;
import org.example.enums.PagesEnum;
import org.junit.*;

import static org.example.ThreadObjects.pages;
import static org.example.ThreadObjects.webDriverRunner;

public class MainPageTests {

    @Before
    public void setUp() {
        BaseActions.openPage();
    }

    @Test
    public void searchProductTest() {
        MainPageActions.enterSearchFieldAndClickSearchButton("Blouse");

        Assert.assertTrue(Utils.pageIsOpened(PagesEnum.SEARCH_PAGE));
        Assert.assertEquals("1 result has been found.", pages().searchPage().getHeadingCounterText());
    }

    @Test
    public void addToCartTest() {
        pages().mainPage().clickAddToCartButton(0);
        Assert.assertTrue(pages().layerCartForm().formIsDisplayed());

        pages().layerCartForm().clickContinueShoppingButton();
        Assert.assertTrue(Utils.pageIsOpened(PagesEnum.MAIN_PAGE));
    }

    @Test
    public void signInTest() {
        BaseActions.signIn(Parameters.testEmail, Parameters.testPassword);
        Assert.assertTrue(Utils.pageIsOpened(PagesEnum.MY_ACCOUNT));
    }

    @AfterClass
    public static void afterClass() {
        webDriverRunner().close();
    }
}
