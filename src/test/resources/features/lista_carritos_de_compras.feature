# language:es

  @Get

  Característica: Consulta de carritos en la API

    Antecedentes:
      Dado que el usuario quiere consultar los carritos disponibles

    Esquema del escenario: Consulta de carritos disponibles
      Cuando realiza una solicitud GET al recurso "<responses>"
      Entonces la respuesta debe tener un código de estado HTTP <code>
      Y validar el cuerpo de la respuesta "<schema>"

      Ejemplos:
        | responses  | code | schema                   |
        | successful | 200  | successful_shopping_cart |
        | failed     | 400  | shopping_cart_failed     |



