package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {

    private WebDriver driver;
    By textBlocks = By.className("iscroll-added");

    public InfiniteScrollPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     *
     * Baja hasta que el parrafo con el indice especificado sea visible
     *
     * @param index 1-base
     */
    public void scrollToParagraph(int index){
        String script = "window.scrollTo(0,document.body.scrollHeight)";

        var jsExecutor = (JavascriptExecutor)driver;
        while(getNumberOfParagraphs() < index){
            jsExecutor.executeScript(script);
        }
    }

    private int getNumberOfParagraphs(){
        return driver.findElements(textBlocks).size();
    }
}
