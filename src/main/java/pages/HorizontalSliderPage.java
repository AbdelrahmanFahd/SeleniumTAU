package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HorizontalSliderPage {
    WebDriver driver;

    HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = ".sliderContainer input")
    WebElement Slider;

    @FindBy(id = "range")
    WebElement rangeText;

    public void moveSlider(String value) {
        while (!getText().equals(value)) {
            Slider.sendKeys(Keys.ARROW_RIGHT);

        }
    }

    public String getText() {
        return rangeText.getText();

    }
}
