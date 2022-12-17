package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WYSIWYGEditorPage {
    WebDriver driver;

    WYSIWYGEditorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "tinymce")
    WebElement textArea;

    @FindBy(css = "button[title=\"Increase indent\"]")
    WebElement increaseIndent;


    private void switchToFrame() {

        driver.switchTo().frame("mce_0_ifr");
    }

    private void switchToMainArea() {

        driver.switchTo().parentFrame();
    }

    public void clearArea() {
        switchToFrame();
        textArea.clear();
        switchToMainArea();
    }

    public void sendTextToArea(String Text) {
        switchToFrame();
        textArea.sendKeys(Text);
        switchToMainArea();
    }

    public String getTextFromEditor() {
        switchToFrame();
        String text = textArea.getText();
        switchToMainArea();

        return text;
    }

    public void setIncreaseIndent() {
        increaseIndent.click();
    }

}
