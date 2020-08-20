package org.example;

import org.example.configs.BaseConfig;
import org.example.configs.Parameters;
import org.openqa.selenium.WebDriver;

public class WebDriverRunner {
    private static WebDriver driver;

    static {
        BaseConfig.initDriver(Parameters.CURRENT_BROWSER);
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void setWebDriver(WebDriver driver) {
        WebDriverRunner.driver = driver;
    }

    public static void close() {
        driver.close();
    }
}
