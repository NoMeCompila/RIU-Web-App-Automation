package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RiuHome;


public class RiuHomeTest extends BaseTest {
    @Test(groups = {"smoke"})
    public void searchRiuHome() throws InterruptedException {
        RiuHome riuHome = new RiuHome(driver);
        riuHome.navigateToRiu();
        riuHome.clickRegister();
        Thread.sleep(3000);
    }
}
