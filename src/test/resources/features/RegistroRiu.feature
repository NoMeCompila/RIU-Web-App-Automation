Feature: Registro de usuario en RIU

  @smoke
  Scenario: Navegar a la página de RIU y abrir el formulario de registro
    Given que el usuario navega a la pagina principal de RIU
    When el usuario acepta las cookies
    And hace clic en el boton de registrarse
    Then se deberia mostrar el formulario de registro