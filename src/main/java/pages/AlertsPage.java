package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {

    WebDriver driver;

    AlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = ".//button[text()=\"Click for JS Alert\"]")
    WebElement triggerAlertButton;
    @FindBy(xpath = ".//button[text()=\"Click for JS Confirm\"]")
    WebElement triggerConfirmButton;

    @FindBy(xpath = ".//button[text()=\"Click for JS Prompt\"]")
    WebElement triggerPromptButton;


    @FindBy(id = "result")
    WebElement result;

    public void clickTriggerAlertButton() {
        triggerAlertButton.click();
    }

    public void clickTriggerConfirmButton() {
        triggerConfirmButton.click();}


    public void clickTriggerPromptButton() {
        triggerPromptButton.click();}

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();}


    public void setValueToPrompt(String value) {
        driver.switchTo().alert().sendKeys(value);}

    public String getAlertText() {

        return driver.switchTo().alert().getText();
    }

    public String getResult() {

        return result.getText();
    }

}
