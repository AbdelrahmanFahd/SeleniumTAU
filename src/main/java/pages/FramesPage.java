package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage {

    WebDriver driver;

    FramesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Nested Frames")
    WebElement nestedFramesButton;

    @FindBy(tagName = "body")
    WebElement bodyFrame;

    public void clickNestedFrames() {
        nestedFramesButton.click();
    }

    private void switchToTopFrame() {

        driver.switchTo().frame("frame-top");
    }

    private void switchToLeftFrame() {

        driver.switchTo().frame("frame-left");
    }

    private void switchToBottomFrame() {

        driver.switchTo().frame("frame-bottom");
    }

    private void switchToMainArea() {

        driver.switchTo().parentFrame();
    }

    public String getTextOfLeftFrame() {
        switchToTopFrame();
        switchToLeftFrame();
        String text = getFrameText();
        switchToMainArea();
        switchToMainArea();
        return text;
    }

    public String getTextOfBottomFrame() {
        switchToBottomFrame();
        String text = getFrameText();
        switchToMainArea();
        return text;
    }

    private String getFrameText() {
        return bodyFrame.getText();
    }

}
