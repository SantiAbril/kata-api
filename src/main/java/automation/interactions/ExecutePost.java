package automation.interactions;

import automation.exceptions.ErrorServicesException;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpStatus;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

import static automation.utils.Constant.EXCEPTION_ERROR_CONSUMPTION_SERVICE;
import static io.restassured.http.ContentType.JSON;

public class ExecutePost implements Interaction {
    private final String resource;
    private final String resources;

    public ExecutePost(String resource, String resources) {
        this.resource = resource;
        this.resources = resources;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        String body = null;
        switch (resources) {
            case "successful add a new cart":
                try {
                    body = new String(Files.readAllBytes(Paths.get("src/test/resources/bodyPost.json")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String bodySuccess = body;
                actor.attemptsTo(
                        Post.to(resource)
                                .with(request -> request
                                        .contentType(JSON)
                                        .body(bodySuccess)
                                        .headers("accept", "application/json")
                                        .relaxedHTTPSValidation()
                                        .log().all()
                                )
                );
                if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK) {
                    throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
                }
                break;
            case "failed add a new cart":
                try {
                    body = new String(Files.readAllBytes(Paths.get("src/test/resources/bodyPostFailed.json")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String bodyFailed = body;
                actor.attemptsTo(
                        Post.to(resource)
                                .with(request -> request
                                        .contentType(JSON)
                                        .body(bodyFailed)
                                        .headers("accept", "application/json")
                                        .relaxedHTTPSValidation()
                                        .log().all()
                                )
                );
                if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_BAD_REQUEST) {
                    throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
                }
                break;
            default:
                throw new IllegalArgumentException("El valor " + resources + "no coincide con ninguno de los case definidos.");
        }
    }

    public static ExecutePost service(String resource, String resources) {
        return Tasks.instrumented(ExecutePost.class, resource, resources);
    }
}
