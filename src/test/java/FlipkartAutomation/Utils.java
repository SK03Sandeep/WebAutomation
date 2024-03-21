package FlipkartAutomation;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class Utils {
    public WebDriver driver;
    Utils(WebDriver d){
        this.driver=d;
    }
    public void WindowSwitch(String p)
    { String parent=p;
        Set<String> allhandles= driver.getWindowHandles();
         for(String var: allhandles)
         {
             if(var!=parent)
                 driver.switchTo().window(var);
         }
    }
}
