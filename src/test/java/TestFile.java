import Utilites.ConfProperties;
import Utilites.ScreenshotHelper;
import Utilites.WebDriverManager;
import org.junit.AfterClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestFile {

    private static WebDriver driver;


    @BeforeEach
    public void setUp() {

        driver = WebDriverManager.getDriver();
        driver.get(ConfProperties.getProperty("ordner"));
    }


    @Test
    public void testFileCreationDateFile1() {
        String testName = "testFileCreationDateFile1";

        String targetFileName = "TestFenster1.txt";
        String expectedCreationDate = "11.09.23, 10:41:33";

        WebElement pilot_file;
        try {
            pilot_file = driver.findElement(By.linkText(targetFileName));
        } catch (NoSuchElementException e) {
            ScreenshotHelper.takeScreenshot(driver, "Error_" + testName + " ");
            fail("File " + targetFileName + " wurde nicht gefunden");
            return;
        }

        WebElement fileCreationDateElement;
        try {
            fileCreationDateElement = driver.findElement(By.xpath("//td[contains(@data-value, '" + pilot_file.getText() + "')]/following-sibling::td[@class='detailsColumn'][2]"));
        } catch (NoSuchElementException e) {
            ScreenshotHelper.takeScreenshot(driver, "Error_" + testName + " ");
            fail("fileCreationDateElement wurde nicht gefunden");
            return;
        }
        ScreenshotHelper.takeScreenshot(driver, testName + " ");
        String fileCreationDate = fileCreationDateElement.getText();
        Assertions.assertNotNull(fileCreationDate);
        assertEquals(expectedCreationDate, fileCreationDate);
    }

    @Test
    public void testFileCreationDateFile2() {

        String testName = "testFileCreationDateFile2";

        String targetFileName = "TestFenster2.txt";
        String expectedCreationDate = "11.09.23, 12:14:03";

        WebElement pilot_file;
        try {
            pilot_file = driver.findElement(By.linkText(targetFileName));
        } catch (NoSuchElementException e) {
            ScreenshotHelper.takeScreenshot(driver, "Error_" + testName + " ");
            fail("File " + targetFileName + " wurde nicht gefunden");
            return;
        }

        WebElement fileCreationDateElement;
        try {
            fileCreationDateElement = driver.findElement(By.xpath("//td[contains(@data-value, '" + pilot_file.getText() + "')]/following-sibling::td[@class='detailsColumn'][2]"));
        } catch (NoSuchElementException e) {
            ScreenshotHelper.takeScreenshot(driver, "Error_" + testName + " ");
            fail("fileCreationDateElement wurde nicht gefunden");
            driver.quit();
            return;
        }
        ScreenshotHelper.takeScreenshot(driver, testName + " ");
        String fileCreationDate = fileCreationDateElement.getText();
        Assertions.assertNotNull(fileCreationDate);
        assertEquals(expectedCreationDate, fileCreationDate);
    }

    @Test
    public void testFileCreationDateFile3() {

        String testName = "testFileCreationDateFile3";
        String targetFileName = "TestFenster3.txt";
        String expectedCreationDate = "11.09.23, 12:14:03";

        WebElement pilot_file;
        try {
            pilot_file = driver.findElement(By.linkText(targetFileName));

        } catch (NoSuchElementException e) {
            ScreenshotHelper.takeScreenshot(driver, "Error_" + testName + " ");
            fail("File " + targetFileName + " wurde nicht gefunden");
            return;
        }


        WebElement fileCreationDateElement;
        try {
            fileCreationDateElement = driver.findElement(By.xpath("//td[contains(@data-value, '" + pilot_file.getText() + "')]/following-sibling::td[@class='detailsColumn'][2]"));
        } catch (NoSuchElementException e) {

            ScreenshotHelper.takeScreenshot(driver, "Error_" + testName + " ");
            fail("fileCreationDateElement wurde nicht gefunden");
            return;
        }
        ScreenshotHelper.takeScreenshot(driver, testName + " ");
        String fileCreationDate = fileCreationDateElement.getText();
        Assertions.assertNotNull(fileCreationDate);
        assertEquals(expectedCreationDate, fileCreationDate);
    }

    @Test
    public void testFileCreationDateFile4() {

        String testName = "testFileCreationDateFile4";
        String targetFileName = "TestFenster2.txt";
        String expectedCreationDate = "11.09.23, 12:14:03";

        WebElement pilot_file;
        try {
            pilot_file = driver.findElement(By.linkText(targetFileName));
        } catch (NoSuchElementException e) {
            ScreenshotHelper.takeScreenshot(driver, "Error_" + testName + " ");
            fail("File " + targetFileName + " wurde nicht gefunden");
            return;
        }

        WebElement fileCreationDateElement;
        try {
            fileCreationDateElement = driver.findElement(By.xpath("//td[contains(@data-value, '" + pilot_file.getText() + "')]/following-sibling::td[@class='detailsColumn'][2]"));
        } catch (NoSuchElementException e) {
            ScreenshotHelper.takeScreenshot(driver, "Error_" + testName + " ");
            fail("fileCreationDateElement wurde nicht gefunden");
            driver.quit();
            return;
        }
        ScreenshotHelper.takeScreenshot(driver, testName + " ");
        String fileCreationDate = fileCreationDateElement.getText();
        Assertions.assertNotNull(fileCreationDate);
        assertEquals(expectedCreationDate, fileCreationDate);
    }


    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}



