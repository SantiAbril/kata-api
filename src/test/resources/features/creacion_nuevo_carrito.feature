# language:es

  @Post

  Característica: Creación de carritos en la API

    Antecedentes:
      Dado que el usuario quiere crear un nuevo carrito

    Escenario: Creación exitosa de carrito
      Cuando realiza una solicitud POST al recurso correspondiente con los datos del carrito
      Entonces la respuesta debe tener un código de estado HTTP 200
      Y el cuerpo de la respuesta debe contener los datos del nuevo carrito

    Escenario: Creación fallida de carrito debido a campos vacíos en el cuerpo de la solicitud
      Cuando realiza una solicitud POST al recurso correspondiente con campos vacíos en el cuerpo de la solicitud
      Entonces la respuesta debe tener un código de estado HTTP 400
      Y el cuerpo de la respuesta debe contener un mensaje de error adecuado

