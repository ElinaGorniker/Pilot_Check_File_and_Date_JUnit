package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private static WebDriver driver;

    public WebDriverManager() {
        driver = this.driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            // Инициализация драйвера (в данном случае ChromeDriver)
            System.setProperty(ConfProperties.getProperty("chromedriver_route"), ConfProperties.getProperty("chromedriver"));
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
