# language:es

  @Get

  Característica: Consumo de métodos de carritos de compra

    Antecedentes:
      Dado que el usuario desea consumir los métodos de la API

    Esquema del escenario: Consumo de los métodos de la API para carritos de compra
      Cuando realiza una solicitud "<method>" al recurso "<responses>"
      Entonces la respuesta debe tener un código de estado HTTP <code>
      Y validar el cuerpo de la respuesta "<schema>"

      Ejemplos:
        | method | responses                 | code | schema                   |
        | GET    | successful get all carts  | 200  | successful_shopping_cart |
        | GET    | failed get all carts      | 400  | shopping_cart_failed     |
        | POST   | successful add a new cart | 200  | successful_post          |
        | POST   | failed add a new cart     | 400  | shopping_cart_failed     |



