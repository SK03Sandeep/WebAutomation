package FlipkartAutomation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Cart{
    public static void main(String[]args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        Flipkartpom obj= new Flipkartpom(driver);

        driver.get("https://www.flipkart.com/");
        driver.findElement(obj.searchbox).click();
        Thread.sleep(5000);
        driver.findElement(obj.searchbox).sendKeys("mobiles"); //searching mobiles
        driver.findElement(obj.searchbox).sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        List<WebElement> results=driver.findElements(By.xpath("//div[@id=\"container\"]/div/div[3]/div[1]/div[2]/div"));
        for(int i=2;i<5;i++)
        {
            WebElement product=driver.findElement(By.xpath("//div[@id=\"container\"]/div/div[3]/div[1]/div[2]/div["+i+"]/div/div/div/a/div[2]/div[1]/div[1]"));
            String title=product.getText();

            String parent= driver.getWindowHandle();
            Utils obj2= new Utils(driver);

            product.click();
            Thread.sleep(5000);
            obj2.WindowSwitch(parent);

            if(title.contains(driver.getTitle()))
                System.out.println("product opened in new window");

           driver.findElement(obj.cartButton).click();
            Thread.sleep(3000);
            driver.close();
            driver.switchTo().window(parent);

            driver.navigate().refresh();
            Thread.sleep(3000);

            String cartcount=driver.findElement(obj.cartcount).getText();


            if(Integer.parseInt(cartcount)==i-1)
                System.out.println("PRODUCT IS SUCCESSFULLY ADDED TO CART");


            System.out.println("-------------------------------------------------------------------------");
      }
        driver.quit();

    }
}
