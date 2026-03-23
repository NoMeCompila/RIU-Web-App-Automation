package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features", // Dónde están los .feature
        glue = "steps",                           // Dónde está el código Java
        tags = "@smoke",                          // Qué etiquetas ejecutar
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Integración con Allure
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}