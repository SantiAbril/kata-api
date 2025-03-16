# language:es

@Delete

Característica: Eliminación de carritos en la API

  Antecedentes:
    Dado que el usuario quiere eliminar un carrito existente

  Escenario: Eliminación de carrito existente
    Cuando realiza un consumo DELETE al recurso correspondiente con los datos del carrito
    Entonces la respuesta debe tener un código de estado HTTP 200
    Y el cuerpo de la respuesta debe contener los datos del carrito eliminado

  Escenario: Actualización fallida de carrito con solicitud incorrecta
    Cuando realiza un consumo DELETE al recurso correspondiente con parametros incorrectos
    Entonces la respuesta debe tener un código de estado HTTP 400
    Y el cuerpo de la respuesta debe contener un mensaje de error adecuado