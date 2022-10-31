Feature:Ejecutar servicio get user
  Con el fin de obtener data generada en base a la respuesta del servicio post user

  @getservicio
  Scenario:Escenario positivo para realizar la ejecucion de consultar usuarios existentes
    Given Jeisson ejecuta servicio get user
    When Jeisson obtiene el responce del servicio get user
    Then  Jeisson muestra el codigo de respuesta del servicio

