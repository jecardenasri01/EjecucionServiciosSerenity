Feature:Ejecutar servicio get user con un app-id invalido
  Con el fin de obtener data generada en base a la respuesta del servicio post user

  @neg_getservicio
  Scenario:Escenario Negativo para realizar la ejecucion negativa de un servicio con app-id invalido
    Given Jeisson ejecuta servicio get user con appid invalido
    When Jeisson obtiene el responce del servicio get user con appid invalido
    Then  Jeisson muestra el codigo de respuesta del servicio con appid invalido

