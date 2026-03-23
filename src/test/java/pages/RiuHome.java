package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilities.BasePage;

public class RiuHome extends BasePage {

    private final By menuButton = By.xpath("//div/button[@aria-label='Menú']");
    private final By accessButton = By.xpath("//div/button[@aria-label='RIU pro']");
    private final By acceptCookiesBtn = By.id("onetrust-accept-btn-handler");

    public RiuHome(WebDriver driver){
        super(driver);
    }

    public void navigateToRiu(){
        navigateTo("https://www.riu.com/es");
    }

    public void clickAcceptCookies(){
        click(this.acceptCookiesBtn);
    }

    public void clickRegister(){
        click(this.accessButton);
    }

    // Método para preguntar si es visible
    public boolean isAcceptCookiesButtonVisible() {
        return isDisplayed(this.acceptCookiesBtn);
    }

    // Método para preguntar si es clickeable
    public boolean isAcceptCookiesButtonClickable() {
        return isClickable(this.acceptCookiesBtn);
    }

    public boolean isAccessButtonVisible(){
        return isDisplayed(this.accessButton);
    }

    public boolean isAccessbuttonCkickable(){
        return isClickable(this.acceptCookiesBtn);
    }
}