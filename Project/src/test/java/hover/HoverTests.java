package hover;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HoverTests extends BaseTests {
    @Test
    public void testHover(){
        var hoversPage = homepage.clickHovers();
        var caption = hoversPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getTitle(),"name: user1", "Incorrect info");
        assertEquals(caption.getLinkText(),"View profile", "Info missing");
        assertTrue(caption.getLink().endsWith("/users/1"), "Wrong");

    }
}
