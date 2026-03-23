package steps;

import com.sun.source.tree.AssertTree;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.RiuHome;
import pages.LoginModal;
import utilities.TestContext;
import org.testng.Assert;


public class RiuSteps {

    private TestContext context;
    private RiuHome riuHome;
    private LoginModal loginModal;

    public RiuSteps(TestContext context) {
        this.context = context;
    }

    @Given("que el usuario navega a la pagina principal de RIU")
    public void navegarARiu() {
        riuHome = new RiuHome(context.driver);
        riuHome.navigateToRiu();

        String expectedTitle = "RIU Hotels & Resorts · Web Oficial · RIU.com";
        String actualTitle = context.driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "¡Error! El título de la página no es el esperado.");
    }

    @When("el usuario acepta las cookies")
    public void aceptarCookies() {
        // 1. Validamos que el botón sea visible en la pantalla
        boolean isVisible = riuHome.isAcceptCookiesButtonVisible();
        Assert.assertTrue(isVisible, "El botón de aceptar cookies no está visible");
        // 2. Validamos que esté habilitado para recibir clics (opcional, pero muy seguro)
        boolean isClickable = riuHome.isAcceptCookiesButtonClickable();
        Assert.assertTrue(isClickable, "El botón de cookies está visible pero bloqueado/no clickeable");
        riuHome.clickAcceptCookies();
    }

    @And("hace clic en el boton de registrarse")
    public void clicRegistrarse() {
        boolean accessButtonVisible = riuHome.isAccessButtonVisible();
        Assert.assertTrue(accessButtonVisible, "El boton de acceso a RIU Class no es visible");
        boolean accessButtonClickable = riuHome.isAccessbuttonCkickable();
        Assert.assertTrue(accessButtonVisible, "El boton de acceso a RIU Class no es clickeable");
        riuHome.clickRegister();
    }

    @And("completa el formulario de registro")
    public void completaElFormularioDeRegistro() {
        loginModal = new LoginModal(context.driver);
        boolean isModalVisible = loginModal.isLoginModalVisible();
        Assert.assertTrue(isModalVisible, "El Modal de Login no es visible");
        loginModal.clickRegisterTab();
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Then("se deberia mostrar el formulario de registro")
    public void verificarFormulario() throws InterruptedException {
        Thread.sleep(3000);
    }
}