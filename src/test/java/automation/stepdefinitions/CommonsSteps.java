package automation.stepdefinitions;

import automation.environments.Endpoint;
import automation.questions.Schema;
import automation.questions.StatusCode;
import automation.task.*;
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
    public void realizaUnaSolicitudAlRecurso(String methods,String resources){
        COMMON_ACTOR.attemptsTo(
                CalledTask.service(resources)
        );
    }

    @Entonces("la respuesta debe tener un código de estado HTTP {int}")
    public void laRespuestaDebeTenerUnCodigoDeEstadoHTTP(int responseCode){
        COMMON_ACTOR
                .should(seeThat(StatusCode.is(responseCode)));
    }

    @Y("validar el cuerpo de la respuesta {string}")
    public void validarElCuerpoDeLaRespuesta(String bodyResponse){
        COMMON_ACTOR
                .should(seeThat(Schema.expected(bodyResponse)));
    }
}

