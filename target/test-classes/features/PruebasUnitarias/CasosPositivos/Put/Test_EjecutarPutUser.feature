Feature:Ejecutar servicio put user
  Con el fin de obtener data generada en base a la respuesta del servicio modificar user

  @modificarservicio
  Scenario:Escenario positivo para realizar la modificacion de un usuario
    Given Jeisson ejecuta servicio modificar user
    When Jeisson obtiene el responce del servicio modificar user
    Then  Jeisson muestra el codigo de respuesta del servicio modificar user
