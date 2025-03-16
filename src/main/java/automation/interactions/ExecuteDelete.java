package automation.interactions;

import automation.exceptions.ErrorServicesException;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpStatus;

import static automation.utils.Constant.EXCEPTION_ERROR_CONSUMPTION_SERVICE;

public class ExecuteDelete implements Interaction {
    private final String resource;
    private final String resources;

    public ExecuteDelete(String resource, String resources) {
        this.resource = resource;
        this.resources = resources;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Delete.from(resource)
                        .with(request -> request
                                .relaxedHTTPSValidation()
                                .log().all()
                        )
        );
        switch (resources) {
            case "sucessful delete a cart":
                if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK) {
                    throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
                }
                break;
            case "failed delete a cart":
                if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_BAD_REQUEST) {
                    throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
                }
                break;
            default:
                throw new IllegalArgumentException("El valor " + resources + "no coincide con ninguno de los case definidos.");
        }
    }

    public static ExecuteDelete service(String resource, String resources) {
        return Tasks.instrumented(ExecuteDelete.class, resource, resources);
    }
}
