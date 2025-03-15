# language:es

  @Get

  Característica: Consulta de carritos en la API

    Antecedentes:
      Dado que el usuario quiere consultar los carritos disponibles

    Escenario: Consulta exitosa de carritos disponibles
      Cuando realiza una solicitud GET al recurso correspondiente
      Entonces la respuesta debe tener un código de estado HTTP 200
      Y el cuerpo de la respuesta debe contener la lista de carritos

    Escenario: Consulta fallida debido a una solicitud incorrecta
      Cuando se envía la solicitud con parámetros incorrectos
      Entonces la respuesta debe tener un código de estado HTTP 400
      Y el cuerpo de la respuesta debe contener un mensaje de error adecuado