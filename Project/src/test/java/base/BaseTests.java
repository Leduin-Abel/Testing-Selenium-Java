package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {
    private WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver","chromedriver_folder/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");//lanza el webdriver y carga un url
        driver.manage().window().maximize(); //maximiza la ventana, manage.window permite modificar el tamaño de la ventana
        System.out.println(driver.getTitle()); //getTitle Obtiene el titulo de la aplicacion
        driver.quit(); //cierra el navegador y termina la sesion
    }

    public static void main(String args[]) {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}

