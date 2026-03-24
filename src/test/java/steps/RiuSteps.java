package steps;

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

    @And("completa el formulario de registro sin fechas")
    public void completaElFormularioDeRegistro() {
        loginModal = new LoginModal(context.driver);
        boolean isModalVisible = loginModal.isLoginModalVisible();
        Assert.assertTrue(isModalVisible, "El Modal de Login no es visible");
        loginModal.clickRegisterTab();

        String registerTitle = "Regístrate gratis";
        String actualTitle = loginModal.extractTitle();
        Assert.assertEquals(actualTitle, registerTitle);

        Assert.assertTrue(loginModal.isNameTextBoxVisible());
        Assert.assertTrue(loginModal.isNameTextBoxClickable());
        loginModal.typeName("Fernando");

        Assert.assertTrue(loginModal.isLastNameTextBoxVisible());
        Assert.assertTrue(loginModal.isLastNameTextBoxClickable());
        loginModal.typeLastName("Caballero");

        Assert.assertTrue(loginModal.isEmailTextBoxVisible());
        Assert.assertTrue(loginModal.isEmailTextBoxClickable());
        loginModal.typeEmail("test@gmail.com");

        Assert.assertTrue(loginModal.isCountrySelectVisible());
        Assert.assertTrue(loginModal.isCountrySelectClickable());
        loginModal.clickCountrySelect();
        Assert.assertTrue(loginModal.isArgOptVisible());
        loginModal.selectArgentina();

        loginModal.openCalendar();
        loginModal.isNoDateBtnVisible();
        loginModal.continueWithoutDate();

        Assert.assertTrue(loginModal.isGenreSelectVisible());
        Assert.assertTrue(loginModal.isGenreSelectClickable());
        loginModal.clickGenreSelect();
        loginModal.isMaleOptVisible();
        loginModal.selectMale();

        Assert.assertTrue(loginModal.isSalesRadioBtnVisible());
        Assert.assertTrue(loginModal.isSalesRadioBtnClickable());
        loginModal.clickSalesRadioBtn();

        Assert.assertTrue(loginModal.isTermsCheckVisible());
        Assert.assertTrue(loginModal.isTermsCheckClickable());
        Assert.assertTrue(loginModal.isTermsUnchecked());
        loginModal.clickTermsCheck();

        loginModal.clickRegisterBtn();

    }

    @Then("se deberia mostrar la validación de campo requerido para fecha")
    public void verificarFormulario() throws InterruptedException {
        Assert.assertTrue(loginModal.isReqFielVisible());
        //Thread.sleep(3000);
    }
}