Feature:Ejecutar servicio delete user con id inexistente
  Con el fin de obtener data generada en base a la respuesta del servicio post user

  @neg_getserviciosidinexistente
  Scenario:Escenario Negativo para validar la respuesta de un servicio con id incorrecto
    Given Jeisson_ejecuta_servicio_delete_user_con_id_inexistente
    When Jeisson_obtiene_el_responce_del_servicio_delete_user_con_id_inexistente
    Then  Jeisson_muestra_el_codigo_de_respuesta_del_servicio_con_id_inexistente

