package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HoversPage {

    WebDriver driver;

    HoversPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "figure")
    List<WebElement> imagesList;

    private final By boxCaption = By.className("figcaption");

    /**
     * @param index starts at 1
     */
    public FigureCaption hoverOverFigure(int index) {
        Actions actions = new Actions(driver);
        var figure = imagesList.get(index - 1);
        actions.moveToElement(figure).perform();

        return new FigureCaption(figure.findElement(boxCaption));
    }

    public class FigureCaption {
        private final WebElement caption;
        private final By header = By.tagName("h5");
        private final By link = By.tagName("a");

        FigureCaption(WebElement caption) {
            this.caption = caption;
        }

        public boolean isCaptionDisplayed() {
            return caption.isDisplayed();
        }

        public String getTitle() {
            return caption.findElement(header).getText();
        }

        public String getLink() {
            return caption.findElement(link).getAttribute("href");
        }

        public String getLinkText() {
            return caption.findElement(link).getText();
        }

    }

}
