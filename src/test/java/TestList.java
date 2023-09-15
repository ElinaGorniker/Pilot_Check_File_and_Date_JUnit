import Assertations.DropdownListContainsChecker;
import Pages.LoginPage;
import Pages.MainPage;
import Utilites.ConfProperties;
import Utilites.ScreenshotHelper;
import Utilites.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestList {
    private static WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {

        driver = WebDriverManager.getDriver();
        driver.get(ConfProperties.getProperty("demosite"));
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    @ParameterizedTest
    @MethodSource("TestDataGenerator.TestDataLoginGenerator#testLoginFile")
    @DisplayName("Test There is Line in the list")
    public void testLinePositive(String targetLoginName, String targetPasswordName) throws InterruptedException {

        String testName = "Test List" + targetLoginName;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());

        loginPage.enterCredentials(targetLoginName, targetPasswordName);
        loginPage.clickLoginButton();
        Thread.sleep(2000);

        mainPage.filterList.click();
        String valueToCheck = "Name (A to Z)";
        boolean isValuePresent = DropdownListContainsChecker.isValuePresentInDropdownList(mainPage.getFilterList(), valueToCheck);
        if (isValuePresent) {
            System.out.println("Option " + valueToCheck + " ist in der Liste vorhanden");
        } else {

            ScreenshotHelper.takeScreenshot(driver, "Error_" + testName + " " + timestamp);
            Assertions.fail("Option " + valueToCheck + " ist NICHT in der Liste vorhanden");
        }
        ScreenshotHelper.takeScreenshot(driver, testName + " " + timestamp);
    }

    @Ignore
    @ParameterizedTest
    @MethodSource("TestDataGenerator.TestDataLoginGenerator#testLoginFile")
    @DisplayName("Test There is NOT Line in the list")

    public void testLineNegative(String targetLoginName, String targetPasswordName) {

        String testName = "Test List" + targetLoginName;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());

        loginPage.enterCredentials(targetLoginName, targetPasswordName);
        loginPage.clickLoginButton();
        String valueToCheck = "Name (A to Z)";
        boolean isValuePresent = DropdownListContainsChecker.isValuePresentInDropdownList(mainPage.getFilterList(), valueToCheck);
        if (!isValuePresent) {
            System.out.println("Option " + valueToCheck + " ist in der Liste Nicht vorhanden");
        } else {

            ScreenshotHelper.takeScreenshot(driver, "Error_" + testName + " " + timestamp);
            Assertions.fail("Option " + valueToCheck + " ist in der Liste vorhanden");
        }
        ScreenshotHelper.takeScreenshot(driver, testName + " " + timestamp);

    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}