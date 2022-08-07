package base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.Homepage;

import java.time.Duration;
import java.util.List;


public class BaseTests {
    private WebDriver driver;
    protected Homepage homepage;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","chromedriver_folder/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Aplica una espera a toda la app

        goHome();
        homepage = new Homepage(driver); //se le da un handle en la capa de test hacia la aplicacion

        /*Son interacciones del nivel del framework, acá va exclusivamente tests
       // driver.manage().window().maximize(); //maximiza la ventana, manage.window permite modificar el tamaño de la ventana
        //WebElement inputsLink = driver.findElement(By.linkText("Inputs")); //Retorna  solo un elemento de web el primero que encuentre, "By.... es mediante qué lo busca"
        //inputsLink.click();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        System.out.println(driver.getTitle()); //getTitle Obtiene el titulo de la aplicacion */


    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");//lanza el webdriver y carga un url
    }
    @AfterClass
    public void tearDown(){
        driver.quit(); //cierra el navegador y termina la sesion
    }

  /*  public static void main(String args[]) {
        BaseTests test = new BaseTests();
        test.setUp();
    } Este metodo main, no es necesario debido a que testNG encontrará lo que necesita*/
}

