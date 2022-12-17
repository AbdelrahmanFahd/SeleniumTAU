package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleWindowsPage {

    WebDriver driver;

    MultipleWindowsPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Click Here")
    WebElement clickHereButton;

    public void clickHere() {
        clickHereButton.click();}


}
