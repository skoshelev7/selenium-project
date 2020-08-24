package org.example;

import org.example.configs.Parameters;
import org.example.enums.Browser;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverRunner {
    private WebDriver driver;

    public WebDriverRunner() {
        initDriver(Parameters.CURRENT_BROWSER);
    }

    public WebDriverRunner(Browser browser) {
        initDriver(browser);
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public void initDriver(Browser browser) {
        System.setProperty(browser.getDriverName(), browser.getPathToDriver());
        this.driver = browser.create();
        this.driver.manage().timeouts().implicitlyWait(Parameters.TIME_OUT, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
    }

    public void close() {
        driver.close();
    }
}
