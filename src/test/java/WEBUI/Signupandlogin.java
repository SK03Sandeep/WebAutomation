package WEBUI;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Signupandlogin extends Browsers{
    @Test
    public void Signup() throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nava"))));
        WebElement signupmenu= driver.findElement(By.xpath("//a[@id=\"signin2\"]"));

        signupmenu.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h5[@id=\"signInModalLabel\"]"))));

        WebElement username= driver.findElement(By.id("sign-username"));
        WebElement password= driver.findElement(By.id("sign-password"));
        WebElement signupbtn=driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]"));
        username.sendKeys("SunnySunny14");
        Thread.sleep(3000);
        password.sendKeys("idontcare14");
        signupbtn.click();
        Thread.sleep(3000);
        Alert signsuccess= driver.switchTo().alert();
        System.out.println(signsuccess.getText());
        signsuccess.accept();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nava"))));

    }

    @Test
    public void Login() throws InterruptedException {
        String user="SunnySunny14";
        String pwd="idontcare14";

        driver.get("https://www.demoblaze.com/index.html");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@id=\"login2\"]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h5[@id=\"logInModalLabel\"]"))));
        WebElement username= driver.findElement(By.id("loginusername"));
        WebElement password= driver.findElement(By.id("loginpassword"));
        WebElement loginbtn=driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));
        Thread.sleep(5000);
        username.sendKeys(user);
        Thread.sleep(2000);
        password.sendKeys(pwd);
        Thread.sleep(2000);
        loginbtn.click();
        Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(5000);
       wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@id='logout2']"))));

    }

}
