# language:es

  @Get

  Característica: Consulta de carritos en la API

    Antecedentes:
      Dado que el usuario quiere consultar los carritos disponibles

    Esquema del escenario: Consulta de carritos disponibles
      Cuando realiza una solicitud "<method>" al recurso "<responses>"
      Entonces la respuesta debe tener un código de estado HTTP <code>
      Y validar el cuerpo de la respuesta "<schema>"

      Ejemplos:
        | method   | responses  | code | schema                 |
#        | POST     | successful | 200  | successful_post        |
#        | POST     | failed     | 400  | failed_post            |
        | GET      | successful | 200  | successful_shopping_cart |
        | GET      | failed     | 400  | shopping_cart_failed   |



