import Assertations.CheckElementAbsence;
import Pages.MainPage;
import Pages.LoginPage;
import Utilites.ConfProperties;
import Utilites.ScreenshotHelper;
import Utilites.WebDriverManager;
import org.junit.AfterClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestLogin {

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
    @MethodSource("TestDataGenerator.TestDataLoginGenerator#testLoginData")
    @DisplayName("Test Login")
    public void testLoginPositive(String targetLoginName, String targetPasswordName) {

        String testName = "Test" + targetLoginName;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());

        loginPage.enterCredentials(targetLoginName, targetPasswordName);
        loginPage.clickLoginButton();


        try {
            mainPage.isCartButtonDisplayed();
        } catch (NoSuchElementException e) {
            ScreenshotHelper.takeScreenshot(driver, "Error_" + testName + " " + timestamp);
            Assertions.fail("Cart wurde nicht gefunden");
            return;
        }
        ScreenshotHelper.takeScreenshot(driver, testName + " " + timestamp);

    }

    @ParameterizedTest
    @MethodSource("TestDataGenerator.TestDataLoginGenerator#testLoginData")
    @DisplayName("Test Error Massage wird nicht angezeigt")
    public void testLoginNegative(String targetLoginName, String targetPasswordName) {

        String testName = "Test" + targetLoginName;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());
        loginPage.enterCredentials(targetLoginName, targetPasswordName);
        loginPage.clickLoginButton();
        CheckElementAbsence elementChecker = new CheckElementAbsence(driver);
        boolean isElementAbsent = elementChecker.isElementAbsent(loginPage.getErrorMessage());


        if (isElementAbsent) {
            System.out.println("Das Element fehlt auf der Web-Seite. Passed");
        } else {
            ScreenshotHelper.takeScreenshot(driver, "Error_" + testName + " " + timestamp);
            Assertions.fail("Das Element ist auf derWeb-Seite vorhanden. Test failed.");

        }
        ScreenshotHelper.takeScreenshot(driver, testName + " " + timestamp);

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();


    }
}
