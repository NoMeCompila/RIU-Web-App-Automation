package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.RiuHome;
import utilities.TestContext;

public class RiuSteps {

    private TestContext context;
    private RiuHome riuHome;

    // 1. En el constructor SOLO recibimos y guardamos la "caja" (context)
    public RiuSteps(TestContext context) {
        this.context = context;
        // Eliminamos el new RiuHome(...) de aquí
    }

    @Given("que el usuario navega a la pagina principal de RIU")
    public void navegarARiu() {
        // 2. AHORA SÍ: Hooks ya ejecutó el @Before y abrió Chrome.
        // Inicializamos la página con el driver activo.
        riuHome = new RiuHome(context.driver);
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
        Thread.sleep(3000);
    }
}