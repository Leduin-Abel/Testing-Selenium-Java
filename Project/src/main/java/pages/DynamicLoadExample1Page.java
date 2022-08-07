package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadExample1Page {

    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By loadBar = By.id("loading");
    private By loadedText = By.id("finish");


    public DynamicLoadExample1Page(WebDriver driver){
        this.driver = driver;
    }

    public void clickStart(){
    driver.findElement(startButton).click();

    //Solo aplican la espera en el metodo llamado
    Boolean wait = new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.invisibilityOf(driver.findElement(loadBar))); //sin el .until el explicit wait no hace nada
    }

    public String getLoadedText(){
        return driver.findElement(loadedText).getText();
    }






}
