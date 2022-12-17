package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KeyPressesPage {
    WebDriver driver;

    KeyPressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "target")
    WebElement inputField;

    @FindBy(id = "result")
    WebElement result;

    public void enterPi() {
        enterText(Keys.chord(Keys.ALT,Keys.NUMPAD5));
    }

    public void enterText(String key) {
        inputField.sendKeys(key);
    }

    public String getResult() {
        return result.getText();
    }
}
