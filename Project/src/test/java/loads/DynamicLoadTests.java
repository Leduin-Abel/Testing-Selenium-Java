package loads;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DynamicLoadTests extends BaseTests {

    @Test
    public void testWaitUntilHidden(){
        var loadingPage = homepage.clickDynaLoadPage().clickExample1();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(), "Hello World!", "Wrong");

    }
}
