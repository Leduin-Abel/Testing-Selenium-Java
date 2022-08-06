package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWysi(){
        var editorPage = homepage.clickWysiPage();
        editorPage.clearTextArea();

        String text1 = "This is  ";
        String text2 = "SPARTAAAAA";

        editorPage.setTextArea(text1);
        editorPage.decreaseIndention();
        editorPage.setTextArea(text2);

        assertEquals(editorPage.getTextFromEditor(), text1 + text2, "Mistake");
    }

}
