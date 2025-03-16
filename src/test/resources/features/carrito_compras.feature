# language:es

  @Carts

  Característica: Consumo de métodos de carritos de compra

    Antecedentes:
      Dado que el usuario desea consumir los métodos de la API

    Esquema del escenario: Consumo de los métodos de la API para carritos de compra
      Cuando realiza una solicitud "<method>" al recurso "<responses>"
      Entonces la respuesta debe tener un código de estado HTTP <code>
      Y validar el cuerpo de la respuesta "<schema>"

      Ejemplos:
        | method | responses                 | code | schema                          |
        | GET    | successful get all carts  | 200  | success                         |
        | GET    | failed get all carts      | 400  | bad_request                     |
        | POST   | successful add a new cart | 200  | cart_created_or_updated_success |
        #| POST   | failed add a new cart     | 400  | bad_request                     |
        | PUT    | successful update a cart  | 200  | cart_created_or_updated_success |
        | PUT    | failed update a cart      | 400  | bad_request                     |
        | DELETE | sucessful delete a cart   | 200  | cart_deleted_successfully       |
        | DELETE | failed delete a cart      | 400  | bad_request                     |



