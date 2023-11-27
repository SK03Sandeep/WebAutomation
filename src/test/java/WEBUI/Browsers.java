package WEBUI;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import java.time.Duration;

public class Browsers {

    public static  WebDriver driver;
    public static WebDriverWait wait;

    @Test
    public void OpenChrome()
    {
        WebDriverManager.chromedriver().setup();
       driver= new ChromeDriver();
       driver.manage().window().maximize();
       wait= new WebDriverWait(driver, Duration.ofSeconds(60));

    }
    @Test
    public void OpenEdge()
    {
        WebDriverManager.edgedriver().setup();
        driver= new EdgeDriver();
        driver.manage().window().maximize();

    }
}
