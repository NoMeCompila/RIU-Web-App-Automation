package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BasePage;

/**
 * Clase Page Object que representa la página principal de RIU Hotels & Resorts.
 * Contiene los localizadores web y los métodos de interacción específicos de esta vista.
 */
public class RiuHome extends BasePage {

    private final By menuButton = By.xpath("//div/button[@aria-label='Menú']");
    private final By accessButton = By.xpath("//div/button[@aria-label='RIU pro']");
    private final By acceptCookiesBtn = By.id("onetrust-accept-btn-handler");

    /**
     * Constructor de la página RiuHome.
     * Llama al constructor de la clase padre (BasePage) para inicializar el WebDriver y las esperas.
     *
     * @param driver Instancia del WebDriver compartida en el contexto de la prueba.
     */
    public RiuHome(WebDriver driver){
        super(driver);
    }

    /**
     * Navega directamente a la URL principal de RIU en español.
     */
    public void navigateToRiu(){
        navigateTo("https://www.riu.com/es");
    }

    /**
     * Hace clic en el botón de aceptar cookies del banner inferior.
     */
    public void clickAcceptCookies(){
        click(this.acceptCookiesBtn);
    }

    /**
     * Hace clic en el botón de acceso/registro (RIU pro) ubicado en la cabecera.
     */
    public void clickRegister(){
        click(this.accessButton);
    }

    /**
     * Verifica si el botón para aceptar cookies está visible en la interfaz del usuario.
     *
     * @return true si el elemento está desplegado en pantalla, false en caso contrario.
     */
    public boolean isAcceptCookiesButtonVisible() {
        return isDisplayed(this.acceptCookiesBtn);
    }

    /**
     * Verifica si el botón para aceptar cookies está habilitado y listo para recibir un clic.
     *
     * @return true si el elemento es interactuable, false si está bloqueado o no existe.
     */
    public boolean isAcceptCookiesButtonClickable() {
        return isClickable(this.acceptCookiesBtn);
    }

    /**
     * Verifica si el botón de acceso (RIU pro) está visible en la cabecera.
     *
     * @return true si el elemento está desplegado en pantalla, false en caso contrario.
     */
    public boolean isAccessButtonVisible(){
        return isDisplayed(this.accessButton);
    }

    /**
     * Verifica si el botón de acceso (RIU pro) está habilitado y listo para recibir un clic.
     *
     * @return true si el elemento es interactuable, false en caso contrario.
     */
    public boolean isAccessButtonClickable(){
        return isClickable(this.accessButton);
    }
}