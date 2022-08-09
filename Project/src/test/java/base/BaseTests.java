package base;


import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.Homepage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class BaseTests {
   // private WebDriver driver;
    private EventFiringWebDriver driver; // para que pueda llamar los event listeners debe ser ese especificio
    protected Homepage homepage;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","chromedriver_folder/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver()); // este escucha por eventos
        driver.register(new EventReporter()); // esta escuchando, le entra la clase donde estan los metodos
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
    @AfterMethod
    //solo corre en fallas
    public void takeScreenshotOfFailure(ITestResult result){ //ITestResult es de TestNG y es el resultado de una prueba
       if(ITestResult.FAILURE == result.getStatus())
       {
           var camera = (TakesScreenshot)driver;
           File screenshot = camera.getScreenshotAs(OutputType.FILE); //Toma pantallazos
           try {
               Files.move(screenshot, new File("src/main/resources/Screenshots/testFailure_" + result.getName() + ".png"));
           }
           catch (IOException e){
               e.printStackTrace();
           }
       }

        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE); //Toma pantallazos
        //File es la clase
        try {
            Files.move(screenshot, new File("src/main/resources/Screenshots/test.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }


    //Toma pantallazos despues de cada prueba
     /* public void takeScreenshot(){
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE); //Toma pantallazos
        //File es la clase
        try {
            Files.move(screenshot, new File("src/main/resources/Screenshots/test.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }*/

    }
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

  /*  public static void main(String args[]) {
        BaseTests test = new BaseTests();
        test.setUp();
    } Este metodo main, no es necesario debido a que testNG encontrará lo que necesita*/
}

