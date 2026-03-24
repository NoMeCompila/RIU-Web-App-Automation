Feature: Registro de usuario en RIU

  @smoke
  Scenario: Navegar a la página de RIU y abrir el formulario de registro
    Given que el usuario navega a la pagina principal de RIU
    When el usuario acepta las cookies
    And hace clic en el boton de registrarse
    And completa el formulario de registro sin fechas
    Then se deberia mostrar la validación de campo requerido para fecha