package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RiuHome;

public class RiuSteps {

    WebDriver driver;
    RiuHome riuHome;

    // Usamos las anotaciones @Before y @After DE CUCUMBER, no de TestNG
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        riuHome = new RiuHome(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("que el usuario navega a la pagina principal de RIU")
    public void navegarARiu() {
        riuHome.navigateToRiu();
    }

    @When("el usuario acepta las cookies")
    public void aceptarCookies() {
        riuHome.clickAcceptCookies();
    }

    @When("hace clic en el boton de registrarse")
    public void clicRegistrarse() {
        riuHome.clickRegister();
    }

    @Then("se deberia mostrar el formulario de registro")
    public void verificarFormulario() throws InterruptedException {
        // Mantenemos tu Thread.sleep por ahora, luego lo cambiaremos por un Assert real
        Thread.sleep(3000);
    }
}