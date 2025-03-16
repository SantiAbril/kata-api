package automation.stepdefinitions;

import automation.environments.Endpoint;
import automation.task.CallingGetTask;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;

import static automation.utils.Constant.COMMON_ACTOR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CommonPostStep {
    @Dado("que el usuario quiere crear un nuevo carrito")
    public void queElUsuarioQuiereCrearUnNuevoCarrito() {

        COMMON_ACTOR.describedAs("Envia la solicitud POST");
    }

    @Cuando("realiza un consumo POST al recurso correspondiente con los datos del carrito")
    public void realizaUnConsumoPOSTAlRecursoCorrespondienteConLosDatosDelCarrito() {
  /*      COMMON_ACTOR.attemptsTo(
                CallingGetTask.service(Endpoint.CARTS)
        );*/
    }


}