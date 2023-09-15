package Assertations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckElementAbsence {
    private WebDriver driver;

    public CheckElementAbsence(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementAbsent(WebElement element) {
        try {
            element.isDisplayed(); // Попытаемся проверить, отображается ли элемент
            return false; // Элемент найден, возвращаем false
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return true; // Элемент не найден, возвращаем true
        }
    }
}