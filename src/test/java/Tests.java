import org.example.ScreenshotHelper;
import org.example.WebDriverManager;
import org.junit.AfterClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class Tests {

    private static WebDriver driver;

    @BeforeEach
    public void setUp() {

        driver = WebDriverManager.getDriver();


        driver.get("C:\\Users\\e.gorniker\\Documents\\Pilot_autotest");

    }

    @Test
    public void testFileCreationDateFile1() throws InterruptedException {
        String testName = "testFileCreationDateFile1";
        // driver.get("C:\\Users\\e.gorniker\\Documents\\Pilot_autotest");
        String targetFileName = "TestFenster1.txt";
        String expectedCreationDate = "11.09.23, 10:41:33";

        WebElement pilot_file;
        try {
            pilot_file = driver.findElement(By.linkText(targetFileName));
        } catch (NoSuchElementException e) {
            fail("File " + targetFileName + " wurde nicht gefunden");
            return;
        }

        WebElement fileRow;
        try {
            fileRow = driver.findElement(By.xpath("//tr/td[@data-value='" + targetFileName + "']"));
        } catch (NoSuchElementException e) {
            fail("fileRow wurde nicht gefunden");
            return;
        }

        WebElement fileCreationDateElement;
        try {
            fileCreationDateElement = driver.findElement(By.xpath("//td[contains(@data-value, '" + pilot_file.getText() + "')]/following-sibling::td[@class='detailsColumn'][2]"));
        } catch (NoSuchElementException e) {
            fail("fileCreationDateElement wurde nicht gefunden");
            return;
        }
        ScreenshotHelper.takeScreenshot(driver, testName + " ");
        String fileCreationDate = fileCreationDateElement.getText();
        assertNotNull(fileCreationDate);
        assertEquals(expectedCreationDate, fileCreationDate);
    }

    @Test
    public void testFileCreationDateFile2() throws InterruptedException {
        //driver.get("C:\\Users\\e.gorniker\\Documents\\Pilot_autotest");
        String testName = "testFileCreationDateFile2";

        String targetFileName = "TestFenster2.txt";
        String expectedCreationDate = "11.09.23, 12:14:03";

        WebElement pilot_file;
        try {
            pilot_file = driver.findElement(By.linkText(targetFileName));
        } catch (NoSuchElementException e) {
            fail("File " + targetFileName + " wurde nicht gefunden");
            return;
        }

        WebElement fileRow;
        try {
            fileRow = driver.findElement(By.xpath("//tr/td[@data-value='" + targetFileName + "']"));
        } catch (NoSuchElementException e) {
            fail("fileRow wurde nicht gefunden");
            return;
        }

        WebElement fileCreationDateElement;
        try {
            fileCreationDateElement = driver.findElement(By.xpath("//td[contains(@data-value, '" + pilot_file.getText() + "')]/following-sibling::td[@class='detailsColumn'][2]"));
        } catch (NoSuchElementException e) {
            fail("fileCreationDateElement wurde nicht gefunden");
            driver.quit();
            return;
        }
        ScreenshotHelper.takeScreenshot(driver, testName + " ");
        String fileCreationDate = fileCreationDateElement.getText();
        assertNotNull(fileCreationDate);
        assertEquals(expectedCreationDate, fileCreationDate);
    }

    @Test
    public void testFileCreationDateFile3() {
        //driver.get("C:\\Users\\e.gorniker\\Documents\\Pilot_autotest");
        String testName = "testFileCreationDateFile3";
        String targetFileName = "TestFenster3.txt";
        String expectedCreationDate = "11.09.23, 12:14:03";

        WebElement pilot_file;
        try {
            pilot_file = driver.findElement(By.linkText(targetFileName));
            //ScreenshotHelper.takeScreenshot(driver, testName + " ");
        } catch (NoSuchElementException e) {
            ScreenshotHelper.takeScreenshot(driver, testName + " ");
            fail("File " + targetFileName + " wurde nicht gefunden");
            return;
        }

        WebElement fileRow;
        try {
            fileRow = driver.findElement(By.xpath("//tr/td[@data-value='" + targetFileName + "']"));
        } catch (NoSuchElementException e) {

            fail("fileRow wurde nicht gefunden");
            return;
        }

        WebElement fileCreationDateElement;
        try {
            fileCreationDateElement = driver.findElement(By.xpath("//td[contains(@data-value, '" + pilot_file.getText() + "')]/following-sibling::td[@class='detailsColumn'][2]"));
        } catch (NoSuchElementException e) {

            ScreenshotHelper.takeScreenshot(driver, testName + " ");
            fail("fileCreationDateElement wurde nicht gefunden");
            return;
        }
        ScreenshotHelper.takeScreenshot(driver, testName + " ");
        String fileCreationDate = fileCreationDateElement.getText();
        assertNotNull(fileCreationDate);
        assertEquals(expectedCreationDate, fileCreationDate);
    }

    @Test
    public void testFileCreationDateFile4() throws InterruptedException {
        //driver.get("C:\\Users\\e.gorniker\\Documents\\Pilot_autotest");
        String testName = "testFileCreationDateFile4";
        String targetFileName = "TestFenster2.txt";
        String expectedCreationDate = "11.09.23, 12:14:03";

        WebElement pilot_file;
        try {
            pilot_file = driver.findElement(By.linkText(targetFileName));
        } catch (NoSuchElementException e) {
            fail("File " + targetFileName + " wurde nicht gefunden");
            return;
        }

        WebElement fileRow;
        try {
            fileRow = driver.findElement(By.xpath("//tr/td[@data-value='" + targetFileName + "']"));
        } catch (NoSuchElementException e) {
            fail("fileRow wurde nicht gefunden");
            return;
        }

        WebElement fileCreationDateElement;
        try {
            fileCreationDateElement = driver.findElement(By.xpath("//td[contains(@data-value, '" + pilot_file.getText() + "')]/following-sibling::td[@class='detailsColumn'][2]"));
        } catch (NoSuchElementException e) {
            fail("fileCreationDateElement wurde nicht gefunden");
            driver.quit();
            return;
        }
        ScreenshotHelper.takeScreenshot(driver, testName + " ");
        String fileCreationDate = fileCreationDateElement.getText();
        assertNotNull(fileCreationDate);
        assertEquals(expectedCreationDate, fileCreationDate);
    }


    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}



