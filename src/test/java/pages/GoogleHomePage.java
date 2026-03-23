package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilities.BasePage;

public class GoogleHomePage extends BasePage {

    // 1. Localizadores (Encapsulados como privados)
    // En Google, la barra de búsqueda tiene el atributo name="q"
    private By searchBox = By.name("q");

    // 2. Constructor: Llama al constructor de la clase padre (BasePage)
    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    // 3. Acciones de la página
    public void navigateToGoogle() {
        navigateTo("https://www.google.com");
    }

    public void searchFor(String text) {
        // Usamos el método type heredado de BasePage
        type(searchBox, text);

        // Buscamos el elemento nuevamente para presionar la tecla ENTER
        find(searchBox).sendKeys(Keys.ENTER);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }


    // Método para esperar a que el título contenga un texto específico
    public boolean waitForTitleToContain(String partialTitle) {
        return wait.until(d -> d.getTitle().contains(partialTitle));
    }

}