package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select")
    public WebElement filterList;
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean isCartButtonDisplayed() {
        cartButton.isDisplayed();
        return cartButton.isDisplayed();
    }



    public WebElement getFilterList() {
        return filterList;
    }
}
