package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor: Inicializa el driver y la espera explícita
    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Selenium 4 usa Duration para definir el tiempo de espera
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Encuentra un elemento esperando a que sea visible en el DOM
    protected WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Espera a que el elemento sea clickeable y luego hace clic
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    // Limpia el campo de texto y luego escribe
    public void type(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Obtiene el texto de un elemento
    public String getText(By locator) {
        return find(locator).getText();
    }

    // Verifica si un elemento se está mostrando en la pantalla
    public boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Navega a una URL específica
    public void navigateTo(String url) {
        driver.get(url);
    }
}