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

    public String getText(By locator) {
        return find(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // NUEVO: Verifica si el elemento está listo para recibir un clic
    public boolean isClickable(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (Exception e) {
            return false; // Si se acaba el tiempo de espera y no es clickeable, retorna falso
        }
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public boolean isChecked(By locator){
        try{
            return find(locator).isSelected();
        }catch (Exception e){
            return false;
        }
    }

    public String locatorText(By locator){
        return getText(locator);
    }
}