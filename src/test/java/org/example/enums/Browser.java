package org.example.enums;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public enum Browser {
    CHROME("chromedriver.exe", "webdriver.chrome.driver") {
        public WebDriver create() {
            return new ChromeDriver();
        }
    },
    FIREFOX("geckodriver.exe", "webdriver.gecko.driver") {
        public WebDriver create() {
            return new FirefoxDriver();
        }
    };

    private final String name;
    private final String driverName;

    Browser(String name, String driver) {
        this.name = name;
        this.driverName = driver;
    }

    public String getName() {
        return name;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getPathToDriver() {
        return new File("src\\test\\resources\\drivers\\" + this.getName()).getAbsolutePath();
    }

    public abstract WebDriver create();
}
