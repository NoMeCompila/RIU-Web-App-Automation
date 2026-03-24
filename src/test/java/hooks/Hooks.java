package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestContext;

public class Hooks {

    private TestContext context;

    /**
     * Constructor de la clase Hooks utilizado para la inyección de dependencias.
     * PicoContainer llama a este constructor automáticamente para compartir
     * el estado de la prueba entre esta clase y las distintas clases de Steps.
     *
     * @param context El contexto de prueba compartido (TestContext) donde se almacenará el WebDriver.
     */
    public Hooks(TestContext context) {
        this.context = context;
    }

    /**
     * Método de configuración que se ejecuta automáticamente antes de cada escenario de prueba.
     * Se encarga de inicializar una nueva sesión del navegador (ChromeDriver),
     * maximizar la ventana para evitar problemas de visibilidad de elementos,
     * y guardar esta instancia en el contexto compartido.
     */
    @Before
    public void setUp() {
        context.driver = new ChromeDriver();
        context.driver.manage().window().maximize();
    }

    /**
     * Método de limpieza que se ejecuta automáticamente al finalizar cada escenario de prueba,
     * sin importar si la prueba pasó o falló.
     * Se encarga de cerrar el navegador de forma segura y destruir la instancia
     * del WebDriver para liberar recursos de la memoria de la computadora.
     */
    @After
    public void tearDown() {
        if (context.driver != null) {
            context.driver.quit();
        }
    }
}