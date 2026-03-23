package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    // Protected para que las clases de prueba puedan usar el driver
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Selenium Manager autoconfigura el ChromeDriver aquí
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        // Cierra el navegador y mata la sesión al terminar cada prueba
        if (driver != null) {
            driver.quit();
        }
    }
}