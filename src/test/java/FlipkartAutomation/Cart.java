package FlipkartAutomation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

/* this testcase open the products in the new window, validate if right product window is opened or not, add product to the cart, 
 navigates back to parent window and validate product count in cart icon is getting incremeneted or not as number of products increases*/
     
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

        List<WebElement> results=driver.findElements(By.xpath("//div[@id=\"container\"]/div/div[3]/div[1]/div[2]/div")); // Colleting search results
        for(int i=2;i<5;i++)
        {
            WebElement product=driver.findElement(By.xpath("//div[@id=\"container\"]/div/div[3]/div[1]/div[2]/div["+i+"]/div/div/div/a/div[2]/div[1]/div[1]"));
            String title=product.getText();

            String parent= driver.getWindowHandle();
            Utils obj2= new Utils(driver);

            product.click(); 
            Thread.sleep(5000);
            obj2.WindowSwitch(parent);// navigating to new product window

            if(title.contains(driver.getTitle()))
                System.out.println("product opened in new window"); // validating if right product window is opened or not

           driver.findElement(obj.cartButton).click(); //adding to cart
            Thread.sleep(3000);
            driver.close();
            driver.switchTo().window(parent); // Switching back to parent window

            driver.navigate().refresh();
            Thread.sleep(3000);

            String cartcount=driver.findElement(obj.cartcount).getText();


            if(Integer.parseInt(cartcount)==i-1) // cart count icon increment validation
                System.out.println("PRODUCT IS SUCCESSFULLY ADDED TO CART");


            System.out.println("-------------------------------------------------------------------------");
      }
        driver.quit();

    }
}
