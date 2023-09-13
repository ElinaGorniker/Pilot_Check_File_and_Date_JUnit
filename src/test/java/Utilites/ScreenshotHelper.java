package Utilites;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenshotHelper {

    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        try {
            // WebDriver zu TakesScreenshot bringen
            TakesScreenshot ts = (TakesScreenshot) driver;

            // Screenshot als File erstellen
            File source = ts.getScreenshotAs(OutputType.FILE);

            // Kopieren des Screenshots an den angegebenen Speicherort
            FileUtils.copyFile(source, new File("src/main/resources/Screenshots/" + screenshotName + ".png"));
            System.out.println("Screenshot wurde erstellt " + screenshotName + ".png");
        } catch (Exception e) {
            System.out.println("Der Screenshot konnte nicht erstellt werden: " + e.getMessage());
        }
    }
}

