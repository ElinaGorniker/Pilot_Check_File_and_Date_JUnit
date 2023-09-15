package Assertations;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownListNotContainsChecker {

    public static boolean isValueNotPresentInDropdownList(WebElement dropdownElement, String value) {
        Select dropdown = new Select(dropdownElement);
        for (WebElement option : dropdown.getOptions()) {
            if (option.getText().equals(value)) {
                return false;
            }
        }
        return true;
    }
}
