package javascript;

import base.BaseTests;
import org.testng.annotations.Test;

public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollToTable(){
        homepage.clickLongAndWidePage().scrollToTable();
    }

    @Test
    public void testScrollToParagraph5(){
        homepage.clickInfiniteScrollPage().scrollToParagraph(5);
    }
}
