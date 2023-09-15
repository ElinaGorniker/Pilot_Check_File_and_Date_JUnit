package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement login;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement errorMsg;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterCredentials(String username, String password) {
        login.sendKeys(username);
        this.password.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();

    }

    public WebElement getErrorMessage() {
        return errorMsg;
    }


}
