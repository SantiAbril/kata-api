package automation.stepdefinitions;

import automation.environments.Endpoint;
import automation.questions.Schema;
import automation.questions.StatusCode;
import automation.task.CallingGetTask;
import automation.task.CallingPostTask;
import automation.task.CallingPutTask;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import static automation.utils.Constant.COMMON_ACTOR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CommonsSteps {
    @Dado("que el usuario desea consumir los métodos de la API")
    public void queElUsuarioDeseaConsumirLosMétodosDelaAPI() {
        COMMON_ACTOR.describedAs("Consume los metodos del API");
    }

    @Cuando("realiza una solicitud {string} al recurso {string}")
    public void realizaUnaSolicitudAlRecurso(String metodo,String resources){
        switch (resources) {
            case "successful get all carts":
                COMMON_ACTOR.attemptsTo(
                        CallingGetTask.service(Endpoint.CARTS,resources)
                );
                break;
            case "failed get all carts":
                COMMON_ACTOR.attemptsTo(
                        CallingGetTask.service(Endpoint.CARTS_ERROR,resources)
                );
                break;
            case "successful add a new cart":
                COMMON_ACTOR.attemptsTo(
                        CallingPostTask.service(Endpoint.CARTS,resources)
                );
                break;
            case "failed add a new cart":
                COMMON_ACTOR.attemptsTo(
                        CallingPostTask.service(Endpoint.CARTS,resources)
                );
                break;
            case "successful update a cart":
                COMMON_ACTOR.attemptsTo(
                        CallingPutTask.service(Endpoint.CARTS_PUT,resources)
                );
                break;
            case "failed update a cart":
                COMMON_ACTOR.attemptsTo(
                        CallingPutTask.service(Endpoint.CARTS_ERROR,resources)
                );
                break;
            default:
                throw new IllegalArgumentException("El valor " + resources + " no coincide con ninguno de los case definidos.");
        }
    }

    @Entonces("la respuesta debe tener un código de estado HTTP {int}")
    public void laRespuestaDebeTenerUnCodigoDeEstadoHTTP(int responseCode){
        COMMON_ACTOR
                .should(seeThat(StatusCode.is(responseCode)));
    }

    @Y("validar el cuerpo de la respuesta {string}")
    public void validarElCuerpoDeLaRespuesta(String bodyResponse){
        COMMON_ACTOR
                .should(seeThat(Schema.esperado(bodyResponse)));
    }
}

