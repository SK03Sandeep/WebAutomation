package FlipkartAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
/*
This testcase searches for mobiles in flipkart website, filters the results by applying filters-->ram-8gb and above,customer rating- above 4,brands-oneplus and samsung and
Prints the mobiles models along with their price.
 */
public class Filtermobile{
    public static void main(String[]args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(60));
        Flipkartpom obj= new Flipkartpom(driver);

        driver.get("https://www.flipkart.com/");
        Thread.sleep(10000);
        if(driver.findElement(obj.cancelloginbtn).isDisplayed())
            driver.findElement(obj.cancelloginbtn).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(obj.searchbox)));   //searching mobiles
        driver.findElement(obj.searchbox).click();
        Thread.sleep(5000);
        driver.findElement(obj.searchbox).sendKeys("mobiles");
        driver.findElement(obj.searchbox).sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        if(!driver.findElement(obj.ram8gb).isDisplayed()) {
            driver.findElement(obj.filterram).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(obj.ram8gb)));
            driver.findElement(obj.ram8gb).click();                                           // selecting filter ram 8gb and above
        }
        else
            driver.findElement(obj.ram8gb).click();
        Thread.sleep(5000);

        if(!driver.findElement(obj.rating4star).isDisplayed()) {
            driver.findElement(obj.filtercustomerratings).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(obj.rating4star)));
            driver.findElement(obj.rating4star).click();                                     // selecting filter customer rating 4 and above
        }
        else
            driver.findElement(obj.rating4star).click();

        Thread.sleep(5000);
        if(driver.findElement(obj.brandexpander).isDisplayed())    // expanding all brands list
            driver.findElement(obj.brandexpander).click();
        Thread.sleep(3000);
        driver.findElement(obj.oneplus).click();
        Thread.sleep(5000);
        driver.findElement(obj.samsung).click();
        Thread.sleep(5000);


        // Displaying only brand name and price from all displayed details and printing it.
        List<WebElement> filterresults=driver.findElements(By.xpath("//div[@id='container']/div/div[3]/div/div[2]/div"));
        for(int i=2;i<=25;i++)
        {
            System.out.println("Brand Name-->"+driver.findElement(By.xpath("//div[@id='container']/div/div[3]/div/div[2]/div["+i+"]/div/div/div/a/div[2]/div/div")).getText());
            System.out.println("Price-->"+driver.findElement(By.xpath("//div[@id='container']/div/div[3]/div/div[2]/div["+i+"]/div/div/div/a/div[2]/div[2]/div[1]/div/div[1]")).getText());
            System.out.println("---------------------------------------------------");

        }
        driver.quit();
    }
}
