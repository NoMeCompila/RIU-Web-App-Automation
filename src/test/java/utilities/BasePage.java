package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Clase base para todas las páginas del patrón Page Object Model (POM).
 * Proporciona un "envoltorio" (wrapper) seguro alrededor de los métodos nativos de Selenium,
 * integrando esperas explícitas (WebDriverWait) por defecto para evitar problemas de sincronización.
 */
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Constructor principal de la página base.
     * Inicializa el WebDriver y configura una espera explícita global de 10 segundos
     * para todas las interacciones de los elementos.
     *
     * @param driver Instancia activa del navegador compartida por PicoContainer.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Busca un elemento en el DOM, esperando hasta que sea visible en la pantalla.
     * Este método es de uso interno (protected) para que las páginas hijas construyan sus acciones.
     *
     * @param locator El localizador (By) del elemento a buscar.
     * @return El WebElement encontrado y visible.
     */
    protected WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Espera a que un elemento sea clickeable (visible y habilitado) y luego hace clic sobre él.
     *
     * @param locator El localizador (By) del botón, enlace o elemento interactuable.
     */
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    /**
     * Escribe texto en un campo de entrada (input o textarea).
     * Automáticamente limpia (borra) el contenido previo del campo antes de escribir.
     *
     * @param locator El localizador (By) del campo de texto.
     * @param text    La cadena de texto que se desea ingresar.
     */
    public void type(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Obtiene el texto visible (inner text) de un elemento en la página.
     *
     * @param locator El localizador (By) del elemento.
     * @return El texto contenido en el elemento.
     */
    public String getText(By locator) {
        return find(locator).getText();
    }

    /**
     * Verifica de forma segura si un elemento está desplegado/visible en la pantalla.
     * Captura cualquier excepción (como NoSuchElementException) para evitar que la prueba falle bruscamente.
     *
     * @param locator El localizador (By) del elemento.
     * @return true si es visible, false si no existe o está oculto.
     */
    public boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Verifica de forma segura si un elemento está habilitado y listo para recibir un clic.
     *
     * @param locator El localizador (By) del elemento.
     * @return true si es clickeable, false si la espera expira o el elemento está bloqueado.
     */
    public boolean isClickable(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Navega a una URL específica en el navegador actual.
     *
     * @param url La dirección web completa a la que se desea acceder (ej. "https://www.riu.com").
     */
    public void navigateTo(String url) {
        driver.get(url);
    }

    /**
     * Verifica de forma segura si un elemento tipo checkbox o radio button está marcado.
     *
     * @param locator El localizador (By) del input de tipo checkbox/radio.
     * @return true si está seleccionado/marcado, false en caso contrario o si no se encuentra.
     */
    public boolean isChecked(By locator){
        try{
            return find(locator).isSelected();
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Obtiene el texto de un localizador.
     * Nota: Funcionalmente idéntico a {@link #getText(By)}.
     *
     * @param locator El localizador (By) del elemento.
     * @return El texto visible del elemento.
     */
    public String locatorText(By locator){
        return getText(locator);
    }
}