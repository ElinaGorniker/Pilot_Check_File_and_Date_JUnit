package org.example;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class ScreenshotHelper {

    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        try {
            // Приведение WebDriver к TakesScreenshot
            TakesScreenshot ts = (TakesScreenshot) driver;

            // Создание скриншота как файла
            File source = ts.getScreenshotAs(OutputType.FILE);

            // Копирование скриншота в указанное место
            FileUtils.copyFile(source, new File("src/main/resources/Screenshots/" +screenshotName + ".png"));
            System.out.println("Скриншот создан" + screenshotName);
        } catch (Exception e) {
            System.out.println("Не удалось создать скриншот: " + e.getMessage());
        }
    }
}

