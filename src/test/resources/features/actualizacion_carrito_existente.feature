# language:es

  @Put

  Característica: Actualización de carritos en la API

    Antecedentes:
      Dado que el usuario quiere actualizar un carrito existente

    Escenario: Actualizacion de carrito existente
      Cuando realiza una solicitud PUT al recurso correspondiente con los datos del carrito
      Entonces la respuesta debe tener un código de estado HTTP 200
      Y el cuerpo de la respuesta debe contener los datos del carrito actualizado

    Escenario: Actualización fallida de carrito con solicitud incorrecta
      Cuando realiza una solicitud PUT al recurso correspondiente con parametros incorrectos
      Entonces la respuesta debe tener un código de estado HTTP 400
      Y el cuerpo de la respuesta debe contener un mensaje de error adecuado