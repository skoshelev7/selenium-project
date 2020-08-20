package org.example.tests;

import org.example.configs.Parameters;
import org.example.helpers.Utils;
import org.example.actions.BaseActions;
import org.example.actions.MainPageActions;
import org.example.enums.PagesEnum;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.example.Pages.*;
import static org.example.WebDriverRunner.close;

public class MainPageTests {

    @Before
    public void setUp() {
        BaseActions.openPage();
    }

    @Test
    public void searchProductTest() {
        MainPageActions.enterSearchFieldAndClickSearchButton("Blouse");

        Assert.assertTrue(Utils.pageIsOpened(PagesEnum.SEARCH_PAGE));
        Assert.assertEquals("1 result has been found.", searchPage().getHeadingCounterText());
    }

    @Test
    public void addToCartTest() {
        mainPage().clickAddToCartButton(0);
        Assert.assertTrue(layerCartForm().formIsDisplayed());

        layerCartForm().clickContinueShoppingButton();
        Assert.assertTrue(Utils.pageIsOpened(PagesEnum.MAIN_PAGE));
    }

    @Test
    public void signInTest() {
        BaseActions.signIn(Parameters.testEmail, Parameters.testPassword);
        Assert.assertTrue(Utils.pageIsOpened(PagesEnum.MY_ACCOUNT));
    }

    @After
    public void after() {
        close();
    }
}
