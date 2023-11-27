package WEBUI;
import org.testng.annotations.Test;

public class Cart extends Browsers{
    @Test
    public  void  DisplayCart() throws InterruptedException {
        Demoblazeobjects obj =new Demoblazeobjects();
        obj.ProductsInCart();
    }

    @Test
    public void  confirmandplace() throws InterruptedException {
        Demoblazeobjects obj =new Demoblazeobjects();
        obj.placeorder();
    }
}
