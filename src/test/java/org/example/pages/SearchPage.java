package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPage {

    @FindBy(how = How.XPATH, using = "//span[@class='heading-counter']")
    private WebElement headingCounter;

    public String getHeadingCounterText() {
        return headingCounter.getText();
    }
}
