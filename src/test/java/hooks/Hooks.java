package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestContext;

public class Hooks {

    private TestContext context;

    // PicoContainer inyecta el contexto automáticamente aquí
    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setUp() {
        // Guardamos el navegador en la "caja" compartida
        context.driver = new ChromeDriver();
        context.driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (context.driver != null) {
            context.driver.quit();
        }
    }
}