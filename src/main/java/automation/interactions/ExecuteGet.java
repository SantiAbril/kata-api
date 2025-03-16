package automation.interactions;

import automation.exceptions.ErrorServicesException;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.http.HttpStatus;

import static automation.utils.Constant.EXCEPTION_ERROR_CONSUMPTION_SERVICE;

public class ExecuteGet implements Interaction {
    private final String resource;
    private final String resources;

    public ExecuteGet(String resource, String resources) {
        this.resource = resource;
        this.resources = resources;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Get.resource(resource)
                        .with(request -> request
                                .relaxedHTTPSValidation()
                                .log().all()
                        )
        );
        switch (resources) {
            case "successful get all carts":
                if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK) {
                    throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
                }
                break;
            case "failed get all carts":
                if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_BAD_REQUEST) {
                    throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
                }
                break;
            default:
                throw new IllegalArgumentException("El valor " + resources + "no coincide con ninguno de los case definidos.");
        }
    }

    public static ExecuteGet service(String resource, String resources) {
        return Tasks.instrumented(ExecuteGet.class, resource, resources);
    }
}
