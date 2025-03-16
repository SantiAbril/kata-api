package automation.stepdefinitions;

import automation.environments.Endpoint;
import automation.questions.Schema;
import automation.questions.StatusCode;
import automation.task.CallingGetTask;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import static automation.utils.Constant.COMMON_ACTOR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CommonGetStep {
    @Dado("que el usuario quiere consultar los carritos disponibles")
    public void queElUsuarioQuiereConsultarLosCarritosDisponibles() {
        COMMON_ACTOR.describedAs("Envia la solicitud GET");
    }

    @Cuando("realiza una solicitud {string} al recurso {string}")
    public void realizaUnaSolicitudGETAlRecurso(String metodo,String resources){
        switch (resources) {
            case "successful":
                COMMON_ACTOR.attemptsTo(
                        CallingGetTask.service(Endpoint.CARTS,resources)
                );
                break;
            case "failed":
                COMMON_ACTOR.attemptsTo(
                        CallingGetTask.service(Endpoint.CARTS_ERROR,resources)
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

