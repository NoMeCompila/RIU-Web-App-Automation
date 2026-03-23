package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilities.BasePage;

public class RiuHome extends BasePage {

    private By menuButton = By.xpath("//div/button[@aria-label='Menú']");
    private By accessButton = By.xpath("//div/button[@aria-label='RIU pro']");

    public RiuHome(WebDriver driver){
        super(driver);
    }

    public void navigateToRiu(){
        navigateTo("https://www.riu.com/es");
    }

    public void clickRegister(){
        click(this.accessButton);
    }
}
