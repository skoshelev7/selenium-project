package org.example.configs;

import org.example.WebDriverRunner;
import org.example.enums.Browser;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseConfig {

    public static void initDriver(Browser browser) {
        WebDriver driver;

        System.setProperty(browser.getDriverName(), browser.getPathToDriver());
        driver = browser.create();
        driver.manage().timeouts().implicitlyWait(Parameters.TIME_OUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        WebDriverRunner.setWebDriver(driver);
    }
}
