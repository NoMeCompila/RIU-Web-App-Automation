package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomePage;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void testSearchWikipedia() {
        // 1. Instanciamos la página, pasándole el driver que heredamos de BaseTest
        GoogleHomePage googleHome = new GoogleHomePage(driver);

        // 2. Navegamos a la página
        googleHome.navigateToGoogle();

        // 3. Validamos que el título inicial es correcto (opcional, pero buena práctica)
        Assert.assertEquals(googleHome.getPageTitle(), "Google", "El título inicial de la página no coincide");

        // 4. Realizamos la acción de búsqueda
        googleHome.searchFor("wikipedia");

        // 5. Validamos que la búsqueda se ejecutó delegando la espera a la página
        boolean isTitleUpdated = googleHome.waitForTitleToContain("wikipedia");
        Assert.assertTrue(isTitleUpdated, "El título no se actualizó después de la búsqueda");
    }
}