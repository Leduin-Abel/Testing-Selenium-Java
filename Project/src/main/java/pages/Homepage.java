//PAge object model para el home page

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Homepage {
    private WebDriver driver;
   // private By formAuthenticationLink = By.linkText("Form Authentication"); //metodo rigido de esta manera toca hacerlo para cada link en la pag


    //constructor para el driver
    public  Homepage(WebDriver driver){
        this.driver = driver;

    }

    public  LoginPage  clickFormAuthentication(){
        clickLink("Form Authentication");
        //driver.findElement(formAuthenticationLink).click(); // metodo rigido de esta manera toca hacerlo para cada link en la pag
        return new LoginPage(driver);
    }

    public DropdownPage clickDropdown(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }
    public HoversPage clickHovers(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }
    //Creando un nuevo metodo para darle mas flexibilidad al codigo
    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();

    }

}
