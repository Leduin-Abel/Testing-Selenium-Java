package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygPage {

    private WebDriver driver;
    private  String editorFrameId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentionButton = By.cssSelector("#mceu_12 button"); //test fails due to changes within the page, this selector does not exist and there is no clear way to access the button


    public WysiwygPage(WebDriver driver){
        this.driver = driver;
    }

    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();

    }

    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();

    }

    public String getTextFromEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;


    }

    public void decreaseIndention(){
        driver.findElement(decreaseIndentionButton).click();

    }



    private void switchToEditArea(){
        driver.switchTo().frame(editorFrameId);
    }

    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }


}
