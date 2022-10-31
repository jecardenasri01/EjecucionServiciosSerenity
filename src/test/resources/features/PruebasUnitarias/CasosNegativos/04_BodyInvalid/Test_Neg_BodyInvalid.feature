Feature:Ejecutar servicio create user con body erroneo
  Con el fin de obtener data generada en base a la respuesta del servicio post user

  @neg_getserviciosbodyincorrecto
  Scenario:Escenario Negativo para validar la respuesta de un servicio con body vacio
    Given Jeisson_ejecuta_servicio_create_user_con_body_erroneo
    When Jeisson_obtiene_el_responce_del_servicio_create_user_con_body_erroneo
    Then  Jeisson_muestra_el_codigo_de_respuesta_del_servicio_con_body_erroneo

