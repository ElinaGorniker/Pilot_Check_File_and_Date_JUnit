import Utilites.ConfProperties;
import Utilites.ScreenshotHelper;
import Utilites.WebDriverManager;
import org.junit.AfterClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestParameter {

    private static WebDriver driver;


    @BeforeEach
    public void setUp() {

        driver = WebDriverManager.getDriver();
        driver.get(ConfProperties.getProperty("ordner"));
    }

    @ParameterizedTest
    @MethodSource("TestDataGenerator.TestDataFileGenerator#testDataFile")

    public void testFileCreationDate0(String targetFileName, String expectedCreationDate) {

        WebElement pilot_file;
        String testName = "Test" + targetFileName;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());
        try {
            pilot_file = driver.findElement(By.linkText(targetFileName));
        } catch (NoSuchElementException e) {
            ScreenshotHelper.takeScreenshot(driver, "Error_" + testName + " " + timestamp);
            Assertions.fail("File " + targetFileName + " wurde nicht gefunden");
            return;
        }

        WebElement fileCreationDateElement;
        try {
            fileCreationDateElement = driver.findElement(By.xpath("//td[contains(@data-value, '" + pilot_file.getText() + "')]/following-sibling::td[@class='detailsColumn'][2]"));
        } catch (NoSuchElementException e) {
            ScreenshotHelper.takeScreenshot(driver, "Error_" + testName + " " + timestamp);
            Assertions.fail("fileCreationDateElement wurde nicht gefunden");
            driver.quit();
            return;
        }
        ScreenshotHelper.takeScreenshot(driver, testName + " " + timestamp);
        String fileCreationDate = fileCreationDateElement.getText();
        Assertions.assertNotNull(fileCreationDate);
        Assertions.assertEquals(expectedCreationDate, fileCreationDate);

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();


    }
}



