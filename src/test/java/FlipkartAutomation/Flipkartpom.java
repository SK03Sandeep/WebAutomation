package FlipkartAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Flipkartpom {
    public static WebDriver driver;
            public Flipkartpom(WebDriver d){
                this.driver=d;
            }
    By searchbox = By.xpath("//input[@name='q']");  // flipkart searchbox
    By searchbtn= By.xpath("//button[@type='submit']"); //flipkart search glass
    By cancelloginbtn= By.xpath("/html/body/div[3]/div/span"); //flipkart cancel login icon
    By filterbrandsearchbox= By.xpath("//input[@placeholder='Search Brand']"); // brand filter search box

    By filterbrand=By.xpath("//div[text()='Brand']"); //filter brand label
    By filtercustomerratings=By.xpath("//div[text()='Customer Ratings']"); //filter customer ratings label
    By rating4star= By.xpath("//div[contains(text(),'4★ & above')]"); //filter rating checkbox
    By filterram=By.xpath("//div[contains(text(),'RAM')]"); //filter RAM label
    By ram8gb=By.xpath("//div[contains(text(),'8 GB and Above')]"); //filter RAM 8gb checkbox

    By brandexpander= By.xpath("//span[contains(text(),'MORE')]"); // expand link

    By oneplus= By.xpath("//div[@title='OnePlus']"); // oneplus checkbox
    By samsung= By.xpath("//div[@title='SAMSUNG']"); // samsung checkbox

}
