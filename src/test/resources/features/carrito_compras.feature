# language:es

  @Carts

  Característica: Consumo de métodos de carritos de compra

    Antecedentes:
      Dado que el usuario desea consumir los métodos de la API

    Esquema del escenario: Consumo de los métodos de la API para carritos de compra
      Cuando realiza una solicitud al recurso "<responses>"
      Entonces la respuesta debe tener un código de estado HTTP <code>
      Y validar el cuerpo de la respuesta "<schema>"

      Ejemplos:
        |  | responses                 | code | schema                          |
        |  | successful get all carts  | 200  | success                         |
        |  | failed get all carts      | 400  | bad_request                     |
        |  | successful add a new cart | 200  | cart_created_or_updated_success |
        |  | failed add a new cart     | 400  | bad_request                     |
        |  | successful update a cart  | 200  | cart_created_or_updated_success |
        |  | failed update a cart      | 400  | bad_request                     |
        |  | sucessful delete a cart   | 200  | cart_deleted_successfully       |
        |  | failed delete a cart      | 400  | bad_request                     |



