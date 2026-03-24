# RIU-Web-App-Automation

## 📝 Resumen
Pequeño proyecto diseñado para demostrar mi habilidad en la automatización de interfaces web utilizando Selenium WebDriver y Java, aplicado a una plataforma real de reservas de hoteles.

## 🎯 Objetivo del Proyecto
El objetivo principal de este repositorio es automatizar el flujo de registro de un nuevo cliente en la plataforma de RIU Hotels & Resorts, culminando en la generación de un reporte de pruebas visual y detallado. 

Más allá del código, este proyecto busca destacar una filosofía clave en el aseguramiento de la calidad: **la automatización es solo una herramienta; el verdadero valor para el negocio se descubre primero a través del análisis y las pruebas manuales**. Entender el producto, diseñar los casos de prueba correctos y encontrar los flujos críticos manualmente es el paso fundamental antes de escribir la primera línea de código.

## 🛠️ Tecnologías y Dependencias
Este framework fue construido desde cero aplicando patrones de diseño profesionales (Page Object Model) y desarrollo guiado por comportamiento (BDD). A continuación, el stack tecnológico detallado según el `pom.xml`:

### Lenguaje y Core
* **Java:** Compilado en versión `21`
* **Selenium WebDriver (`selenium-java`):** v`4.18.1`

### Motor de Pruebas y BDD
* **TestNG (`testng`):** v`7.9.0`
* **Cucumber Java (`cucumber-java`):** v`7.15.0`
* **Cucumber TestNG (`cucumber-testng`):** v`7.15.0`
* **Cucumber PicoContainer (`cucumber-picocontainer`):** v`7.15.0` *(Para Inyección de Dependencias)*

### Reportes Visuales (Allure)
* **Allure TestNG (`allure-testng`):** v`2.27.0`
* **Allure Cucumber7 JVM (`allure-cucumber7-jvm`):** v`2.27.0`

### Plugins de Construcción (Maven)
* **Maven Surefire Plugin:** v`3.2.5`
* **Allure Maven Plugin:** v`2.12.0`
* **AspectJ Weaver (`aspectjweaver`):** v`1.9.21` *(Necesario para la intercepción de eventos de Allure en Java 21)*

## 🏗️ Arquitectura del Framework
El proyecto está estructurado para ser altamente escalable y mantenible:
* **`src/test/resources/features/`**: Contiene los archivos `.feature` escritos en lenguaje Gherkin (negocio).
* **`src/test/java/pages/`**: Implementación del patrón *Page Object Model (POM)*. Cada página web es una clase que encapsula sus propios localizadores y métodos.
* **`src/test/java/steps/`**: Definición de pasos (Step Definitions) que conectan Gherkin con Selenium.
* **`src/test/java/utilities/`**: Clases base (`BasePage`, `TestContext`) que manejan la interacción de bajo nivel con el navegador y comparten el estado mediante inyección de dependencias.

## 🚀 Cómo ejecutar las pruebas

Para ejecutar la suite de pruebas desde la terminal, utiliza el siguiente comando filtrando por la etiqueta deseada (por ejemplo, `@smoke`):

```bash
mvn clean test "-Dcucumber.filter.tags=@smoke"
