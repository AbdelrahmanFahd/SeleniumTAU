package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(css = "#login button")
    WebElement login;

    public void setUsername(String user) {
        userNameField.sendKeys(user);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }


    public SecureAreaPage clickLoginButton() {
        login.click();

        return new SecureAreaPage(driver);
    }
}
