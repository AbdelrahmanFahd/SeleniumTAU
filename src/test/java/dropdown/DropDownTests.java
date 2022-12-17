package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DropDownPage;

import static org.testng.Assert.*;

public class DropDownTests extends BaseTests {


    @Test
    public void TestSelectOption() {
        DropDownPage dropDownPage = homePage.clickDropdown();
        dropDownPage.selectFromDropDown("Option 2");
        var selectedOption = dropDownPage.getSelectedOptions();
        assertEquals(selectedOption.size(), 1, "Incorrect number of Selections");
        assertTrue(selectedOption.contains("Option 2"), "Option not Selected");
    }
}
