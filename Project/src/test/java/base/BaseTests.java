package base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Homepage;

import java.util.List;

public class BaseTests {
    private WebDriver driver;
    protected Homepage homepage;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver","chromedriver_folder/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");//lanza el webdriver y carga un url
        homepage = new Homepage(driver); //se le da un handle en la capa de test hacia la aplicacion
        
        /*Son interacciones del nivel del framework, acá va exclusivamente tests
       // driver.manage().window().maximize(); //maximiza la ventana, manage.window permite modificar el tamaño de la ventana
        //WebElement inputsLink = driver.findElement(By.linkText("Inputs")); //Retorna  solo un elemento de web el primero que encuentre, "By.... es mediante qué lo busca"
        //inputsLink.click();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        System.out.println(driver.getTitle()); //getTitle Obtiene el titulo de la aplicacion */

        driver.quit(); //cierra el navegador y termina la sesionk
    }

    public static void main(String args[]) {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}

