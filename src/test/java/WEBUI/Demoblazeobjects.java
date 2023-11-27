package WEBUI;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import  java.lang.*;
public class Demoblazeobjects extends Browsers{

    By categoryPhone= By.xpath("//a[@id=\"itemc\"][1]"); // Webelement category phone
    By categorylaptop=By.xpath("//a[@id=\"itemc\"][2]"); // Webelement category laptop
    By categorymonitor=By.xpath("//a[@id=\"itemc\"][3]"); // Webelement category monitor

    By iphone= By.xpath("//a[contains(text(),'Iphone 6 32gb')]"); //iphone product link
    By macbookpro=By.xpath("//a[contains(text(),'MacBook Pro')]");//macbook laptop product link
    By asus= By.xpath("//a[contains(text(),'ASUS Full HD')]");//asus monitor product link

    By menucartbtn= By.xpath("//a[@id='cartur']");  // Webelement menu label cart button
    By menuhomebtn= By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a"); // Webelement menu label home button
    By addtocartbutton= By.xpath("//a[@class=\"btn btn-success btn-lg\"]"); // Add to cart button

    By tableALLRows=By.xpath("//table//tbody/tr"); // all rows
    By tableALLColums=By.xpath("//table//tbody//td"); // all columns

    By Placeorderbtn= By.xpath("//button[@class='btn btn-success']");
    By purchaseformname= By.xpath("//input[@id='name']");
    By purchaseformcreditcard= By.xpath("//input[@id='card']");
    By purchasebtn= By.xpath("//button[text()='Purchase']");
    By thankyoumsg= By.xpath("//h2[text()='Thank you for your purchase!']");

    public void clickcategoryphone() throws InterruptedException { //function to add phone to cart
        driver.findElement(categoryPhone).click();
        Thread.sleep(5000);
        driver.findElement(iphone).click();
        Thread.sleep(5000);
        driver.findElement(addtocartbutton).click();
        Thread.sleep(5000);

    }

    public void clickcategorylaptop() throws InterruptedException { //function to add laptop to cart
        driver.findElement(categorylaptop).click();
        Thread.sleep(5000);
        driver.findElement(macbookpro).click();
        Thread.sleep(5000);
        driver.findElement(addtocartbutton).click();
        Thread.sleep(5000);

    }

    public void clickcategorymonitor() throws InterruptedException {  //function to add monitor to cart
        driver.findElement(categorymonitor).click();
        Thread.sleep(5000);
        driver.findElement(asus).click();
        Thread.sleep(5000);
        driver.findElement(addtocartbutton).click();
        Thread.sleep(5000);

    }



    public void Handlealert() throws InterruptedException { //function to handle product added alert
        Alert confirmation= driver.switchTo().alert();
        System.out.println(confirmation.getText());
        confirmation.accept();
        Thread.sleep(5000);
        driver.findElement(menuhomebtn).click();
        Thread.sleep(3000);
    }
    public void ProductsInCart() throws InterruptedException
    {
        driver.findElement(menucartbtn).click();
        Thread.sleep(5000);
        int total=0;

        List<WebElement> ProductTitle= driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-striped']//tbody//tr//td[2]"));
        for(int i=1;i<=ProductTitle.size();i++)
        {
            System.out.println(driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped']//tbody//tr["+i+"]//td[2]")).getText());
            String price=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped']//tbody//tr["+i+"]//td[3]")).getText();
            total+=Integer.parseInt(price);
        }
        System.out.println(total);
        }

    public void placeorder() throws InterruptedException {
        String Tmsg= "Thank you for your purchase!";
        driver.findElement(Placeorderbtn).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(purchaseformname)));
        driver.findElement(purchaseformname).sendKeys("Sandeep the King");
        Thread.sleep(3000);
        driver.findElement(purchaseformcreditcard).sendKeys("99988888888899999");
        driver.findElement(purchasebtn).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(thankyoumsg)));

        Assert.assertEquals("Thank you for your purchase!",driver.findElement(thankyoumsg).getText());
        driver.findElement(By.xpath("//button[text()='OK']")).click();

    }
}
