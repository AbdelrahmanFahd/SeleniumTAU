package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingPage {
    WebDriver driver;

    DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Example 1: Element on page that is hidden")
    WebElement example1Button;
    @FindBy(linkText = "Example 2: Element rendered after the fact")
    public WebElement example2Button;

    @FindBy(id = "loading")
    WebElement loadingIndicator;

    @FindBy(css = "#start button")
    public WebElement startButton;

    @FindBy(css = "#finish h4")
    WebElement result;

    public void clickExample1() {
        example1Button.click();
    }

    public void clickExample2() {
        example2Button.click();
    }

    public void clickStart() {
        startButton.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1));
//                                               .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.invisibilityOf(loadingIndicator));
    }

    public void clickStart2() {
        startButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(result));
    }

    public String getTextResult() {
        return result.getText();
    }
}
