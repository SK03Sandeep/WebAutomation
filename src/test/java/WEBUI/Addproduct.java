package WEBUI;
import org.testng.annotations.Test;


/*
This class contains 3 separate test methods Addlaptop,Addmonitor,Addphone which act as separate testcases to add products
to the cart in "demoblaze.com" website. this ui automation follows page object model[POM] design pattern for which all
the web elements and user interactions are stored and performed in a separate class "Demoblazeobjects".

note- I purposefully used thread.sleep() being aware of fact that it pauses script execution to observe interactions on webpage as this is my first website to automate.
*/
public class Addproduct extends Browsers{
    @Test(priority = 2)
    public void Addphone() throws InterruptedException {
        Demoblazeobjects obj=new Demoblazeobjects();
        obj.clickcategoryphone();
        obj.Handlealert();
    }
    @Test(priority = 3)
    public void Addlaptop() throws InterruptedException {
        Demoblazeobjects obj=new Demoblazeobjects();
        obj.clickcategorylaptop();
        obj.Handlealert();
    }
    @Test(priority = 1)
    public void Addmonitor() throws InterruptedException {
        Demoblazeobjects obj=new Demoblazeobjects();
        obj.clickcategorymonitor();
        obj.Handlealert();
    }
}
