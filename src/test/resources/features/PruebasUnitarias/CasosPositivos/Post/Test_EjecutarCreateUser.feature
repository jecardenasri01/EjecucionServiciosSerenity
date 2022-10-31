Feature:Ejecutar servicio create user
  Con el fin de obtener data generada en base a la respuesta del servicio get user

  @postservicio
  Scenario:Escenario positivo  para realizar la creacion de un usuario
    Given Jeisson busca correo disponible para usuario nuevo
    When Jeisson obtiene el responce del servicio create user
    Then  Jeisson muestra el codigo de respuesta del servicio create user

