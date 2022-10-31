Feature:Ejecutar servicio delete user
  Con el fin de obtener data generada en base a la respuesta del servicio delete user

  @deleteservicio
  Scenario:Escenario positivo para realizar la ejecucion de un servicio delete
    Given Jeisson ejecuta servicio delete user
    When Jeisson obtiene el responce del servicio delete user
    Then  Jeisson muestra el codigo de respuesta del servicio delete user

