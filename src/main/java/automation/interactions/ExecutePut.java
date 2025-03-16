package automation.interactions;

import automation.exceptions.ErrorServicesException;
import automation.models.PutHeader;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.apache.http.HttpStatus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static automation.utils.Constant.EXCEPTION_ERROR_CONSUMPTION_SERVICE;
import static io.restassured.http.ContentType.JSON;

public class ExecutePut implements Interaction {
    private final String resource;
    private final String resources;

    public ExecutePut(String resource, String resources) {
        this.resource = resource;
        this.resources = resources;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        String body = null;
        try {
            body = new String(Files.readAllBytes(Paths.get("src/test/resources/bodyPut.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String bodyPut = body;
        actor.attemptsTo(
                Put.to(resource)
                        .with(request -> request
                                .headers(PutHeader.basicHeaders())
                                .body(bodyPut)
                                .relaxedHTTPSValidation()
                                .log().all()
                        )
        );

        switch (resources) {
            case "successful update a cart":
                if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK) {
                    throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
                }
                break;
            case "failed update a cart":
                if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_BAD_REQUEST) {
                    throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
                }
                break;
            default:
                throw new IllegalArgumentException("El valor " + resources + "no coincide con ninguno de los case definidos.");
        }
    }

    public static ExecutePut service(String resource, String resources) {
        return Tasks.instrumented(ExecutePut.class, resource, resources);
    }
}
