# RIU-Web-App-Automation

## 📝 Resumen
Proyecto diseñado para demostrar mi habilidad en la automatización de interfaces web utilizando Selenium WebDriver y Java, aplicado a una plataforma real de reservas de hoteles.

## 🎯 Objetivo del Proyecto
El objetivo principal de este repositorio es automatizar el flujo de registro de un nuevo cliente en la plataforma de RIU Hotels & Resorts, culminando en la generación de un reporte de pruebas visual y detallado. 

Más allá del código, este proyecto busca destacar una filosofía clave en el aseguramiento de la calidad: **la automatización es solo una herramienta; el verdadero valor para el negocio se descubre primero a través del análisis y las pruebas manuales**. Entender el producto, diseñar los casos de prueba correctos y encontrar los flujos críticos manualmente es el paso fundamental antes de escribir la primera línea de código.

## ⚙ Automatización escenario: Validar campo requerido Fecha de nacimiento en registro
```bash
mvn clean test "-Dcucumber.filter.tags=@smoke"
```
https://github.com/user-attachments/assets/51ee8cbd-b89f-4aff-b4a7-b3c90420405e

## Reporte Allure + Cucumber
```bash
mvn allure:serve
```
<img width="1920" height="1040" alt="image" src="https://github.com/user-attachments/assets/bf5d7ffe-349f-48e3-88ea-daef1362f8ef" />

## 🖐 Prueba Manual y Reporte de Bug (Se encuentra un bug de negocio/ de análisis funcional) 
Este bug generalmente no es encontrado si solo se tiene una visión de automatización de pruebas. Aqui se ve el valor de las pruebas funcionales y análisis de requerimientos.
# 🐛 Reporte de Bug: [Registro] Problema de usabilidad extrema en el calendario de "Fecha de nacimiento"

**ID:** BUG-001
**Estado:** Abierto
**Severidad:** Alta (Afecta directamente la tasa de conversión y registro de usuarios)
**Módulo:** Formulario de Registro (RIU Class)

## 📖 Historia de Usuario (Contexto)
> **Como** cliente potencial / usuario nuevo
> **Quiero** poder ingresar o seleccionar mi año, mes y día de nacimiento de forma rápida y sencilla
> **Para** poder completar mi registro en la plataforma cómodamente y sin fricciones.

## 📝 Resumen del Problema
El campo obligatorio "Fecha de nacimiento" en el formulario de registro despliega un componente de calendario inadecuado para este propósito. El calendario actual no permite la navegación directa entre años; obliga al usuario a retroceder mes a mes desde la fecha actual para llegar a su año de nacimiento. Esto hace que el registro sea virtualmente imposible (o extremadamente frustrante) para cualquier usuario. 

Adicionalmente, existe una discrepancia lógica en la interfaz: el componente de calendario muestra un botón primario con el texto "Continuar sin fechas", lo cual contradice las reglas de validación del formulario, ya que el campo está marcado como obligatorio (`*`).

## 👣 Pasos para reproducir
1. Navegar a la página principal de RIU.
2. Hacer clic en el botón de "Entrar con mi cuenta" o "Regístrate gratis".
3. Visualizar el modal "COMPLETA EL FORMULARIO CON TUS DATOS".
4. Hacer clic sobre el campo "Fecha de nacimiento".
5. Observar el componente de calendario desplegado en pantalla.
6. Intentar cambiar el año visible (ej. retroceder al año 1990).
7. Observar los controles disponibles y el botón inferior del modal del calendario.

## ✅ Comportamiento Esperado
* **Navegación:** El componente de calendario debe permitir la navegación y selección directa de **Años**, **Meses** y **Días** (por ejemplo, mediante menús desplegables `dropdown` o vistas de selección por décadas).
* **Coherencia de validación:** Al ser un campo requerido para el registro, el calendario no debe mostrar la opción ni el botón "Continuar sin fechas".

## ❌ Comportamiento Actual
* El usuario solo puede navegar hacia atrás o adelante dando clics **mes a mes** usando las flechas laterales. No hay selector de años.
* Se visualiza un botón rojo de "Continuar sin fechas" incrustado en el componente de fecha de nacimiento.
* **Se Asume que se ha reutilizado el calendario para reserva de fechas en un hotel en lugar de uno para seleccionar fecha de nacimiento.**

## 📎 Evidencia Adjunta
* **Screenshot:** Se adjunta captura de pantalla donde se evidencia el calendario tipo "reserva" aplicado erróneamente al campo de nacimiento, mostrando los meses de Marzo/Abril 2026 y el botón "Continuar sin fechas".
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/6a81bc09-f8ea-4902-9f2d-862901da7593" />

https://github.com/user-attachments/assets/8b83cdb2-61e1-430d-b9b9-b2cfddae13f2


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

### AI Tool
* **Gemini** v`3.1 PRO` (para generación de documentación y sugerencia de mejoras en código)

## 🏗️ Arquitectura del Framework
El proyecto está estructurado para ser altamente escalable y mantenible:
* **`src/test/resources/features/`**: Contiene los archivos `.feature` escritos en lenguaje Gherkin (negocio).
* **`src/test/java/pages/`**: Implementación del patrón *Page Object Model (POM)*. Cada página web es una clase que encapsula sus propios localizadores y métodos.
* **`src/test/java/steps/`**: Definición de pasos (Step Definitions) que conectan Gherkin con Selenium.
* **`src/test/java/utilities/`**: Clases base (`BasePage`, `TestContext`) que manejan la interacción de bajo nivel con el navegador y comparten el estado mediante inyección de dependencias.

## 🚀 Cómo ejecutar las pruebas

Para ejecutar la suite de pruebas desde la terminal, utiliza el siguiente comando filtrando por la etiqueta deseada (por ejemplo, `@smoke`):











