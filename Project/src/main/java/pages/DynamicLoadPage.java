package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadPage {

    private WebDriver driver;

    private By link_Example1 = By.cssSelector("#content > div > a:nth-child(5)");


    public DynamicLoadPage(WebDriver driver){
        this.driver = driver ;

    }

    public DynamicLoadExample1Page clickExample1(){
        driver.findElement(link_Example1).click();
        return new DynamicLoadExample1Page(driver);
    }

}
