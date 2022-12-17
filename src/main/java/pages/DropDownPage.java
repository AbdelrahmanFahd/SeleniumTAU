package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropDownPage {
    WebDriver driver;
    Select dropDownElement;

    DropDownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "dropdown")
    WebElement dropdown;

    public void selectFromDropDown(String option) {
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions() {
        List<WebElement> optionsList = findDropDownElement().getAllSelectedOptions();

     return optionsList.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownElement() {

        return new Select(dropdown);
    }

}
