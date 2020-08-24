package org.example.pages;

import org.example.helpers.Utils;
import org.example.enums.Condition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.example.ThreadObjects.pages;

public class LayerCartForm {

    @FindBy(how = How.XPATH, using = "//div[@id='layer_cart']//div[@class='clearfix']")
    private WebElement layerCartForm;

    public boolean formIsDisplayed() {
        return Utils.elementShouldBe(Condition.VISIBLE, layerCartForm).isDisplayed();
    }

    public MainPage clickContinueShoppingButton() {
        pages().baseActions()
                .clickSpanButton("Continue shopping");
        return pages().mainPage();
    }
}
