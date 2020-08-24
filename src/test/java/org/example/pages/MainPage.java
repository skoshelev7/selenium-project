package org.example.pages;

import org.example.WebDriverRunner;
import org.example.helpers.Utils;
import org.example.actions.BaseActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static org.example.Pages.*;
import static org.example.ThreadObjects.pages;
import static org.example.ThreadObjects.webDriverRunner;

public class MainPage {

    @FindBy(how = How.XPATH, using = "//input[@id='search_query_top']")
    private WebElement searchField;

    @FindBy(how = How.XPATH, using = "//button[@name='submit_search']")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//div[@class='product-container']")
    private List<WebElement> listOfProducts;

    @FindBy(how = How.XPATH, using = "//a[@class='login']")
    private WebElement signInLink;

    public MainPage enterSearchField(String searchText) {
        searchField.sendKeys(searchText);
        return this;
    }

    public SearchPage clickSearchButton() {
        searchButton.click();
        return pages().searchPage();
    }

    public LayerCartForm clickAddToCartButton(Integer number) {
        this.moveToElement(listOfProducts.get(number));
        BaseActions.clickSpanButton("Add to cart");
        return pages().layerCartForm();
    }

    private void moveToElement(WebElement element) {
        new Actions(webDriverRunner().getWebDriver()).moveToElement(element).perform();
    }

    public SignInPage clickSignInLink() {
        signInLink.click();
        return pages().signInPage();
    }
}
