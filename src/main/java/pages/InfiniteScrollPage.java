package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InfiniteScrollPage {
    WebDriver driver;

    InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "jscroll-added")
    List<WebElement> paragraph;

    public void scrollToParagraph(int index) {
        //Normal Scroll
        String script = "window.scrollTo(0,document.body.scrollHeight)";
        var JS = (JavascriptExecutor) driver;
        while (getNumberOfParagraphsPresent() < index) {
            JS.executeScript(script);
        }

    }

    private int getNumberOfParagraphsPresent() {

        return paragraph.size();
    }
}
