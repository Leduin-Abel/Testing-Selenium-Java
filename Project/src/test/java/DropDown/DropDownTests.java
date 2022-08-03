package DropDown;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropDownTests extends BaseTests {

    @Test
    public void testSelectOption(){
        var dropDownPage = homepage.clickDropdown();
        String option = "Option 1"; //como se usa mas de una vez es mejor tenerlo en variable
        dropDownPage.selectFromDropdown(option);
        var selectedOptions = dropDownPage.getSelectedOptiosn();
        assertEquals(selectedOptions.size(), 1, "Incorrect # of selection");
        assertTrue(selectedOptions.contains(option), "Option is not selected");
    }
}
