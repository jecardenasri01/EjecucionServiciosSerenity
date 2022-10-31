Feature:Ejecutar servicio get user con un sin enviar app-id
  Con el fin de obtener data generada en base a la respuesta del servicio post user

  @neg_getserviciosinheader
  Scenario:Escenario Negativo para realizar la ejecucion negativa de un servicio sin enviar app-id
    Given Jeisson_ejecuta_servicio_get_user_sin_enviar_app-id
    When Jeisson_obtiene_el_responce_del_servicio_get_user_sin_enviar_app-id
    Then  Jeisson_muestra_el_codigo_de_respuesta_del_servicio_sin_enviar_app-id

