package automation.interactions;

import automation.exceptions.ErrorServicesException;
import automation.models.PutHeader;
import automation.utils.environments.Endpoint;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.apache.http.HttpStatus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static automation.exceptions.ErrorServicesException.EXCEPTION_ERROR_CONSUMPTION_SERVICE;
import static io.restassured.http.ContentType.JSON;

public class Executions implements Interaction {
    private final String resources;

    public Executions(String resources) {
        this.resources = resources;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        String body = null;
        try {
            body = new String(Files.readAllBytes(Paths.get("src/test/resources/bodyPostSuccess.json")));
            body = new String(Files.readAllBytes(Paths.get("src/test/resources/bodyPostFailed.json")));
            body = new String(Files.readAllBytes(Paths.get("src/test/resources/bodyPut.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String bodyPostSuccess = body;
        String bodyPostFailed = body;
        String bodyPut = body;


        switch (resources) {
            case "successful get all carts":
                actor.attemptsTo(
                        Get.resource(Endpoint.CARTS_SUCCESS)
                                .with(request -> request
                                        .relaxedHTTPSValidation()
                                        .log().all()
                                )
                );
                if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK) {
                    throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
                }
                break;
            case "failed get all carts":
                actor.attemptsTo(
                        Get.resource(Endpoint.CARTS_FAILED)
                                .with(request -> request
                                        .relaxedHTTPSValidation()
                                        .log().all()
                                )
                );
                if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_BAD_REQUEST) {
                    throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
                }
                break;
            case "successful add a new cart":
                actor.attemptsTo(
                        Post.to(Endpoint.CARTS_SUCCESS)
                                .with(request -> request
                                        .contentType(JSON)
                                        .body(bodyPostSuccess)
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
                actor.attemptsTo(
                        Post.to(Endpoint.CARTS_SUCCESS)
                                .with(request -> request
                                        .contentType(JSON)
                                        .body(bodyPostFailed)
                                        .headers("accept", "application/json")
                                        .relaxedHTTPSValidation()
                                        .log().all()
                                )
                );
                if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_BAD_REQUEST) {
                    throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
                }
                break;
            case "successful update a cart":
                actor.attemptsTo(
                        Put.to(Endpoint.CARTS_SUCCESS_PUT_DELETE)
                                .with(request -> request
                                        .headers(PutHeader.basicHeaders())
                                        .body(bodyPut)
                                        .relaxedHTTPSValidation()
                                        .log().all()
                                )
                );
                if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK) {
                    throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
                }
                break;
            case "failed update a cart":
                actor.attemptsTo(
                        Put.to(Endpoint.CARTS_FAILED)
                                .with(request -> request
                                        .headers(PutHeader.basicHeaders())
                                        .body(bodyPut)
                                        .relaxedHTTPSValidation()
                                        .log().all()
                                )
                );
                if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_BAD_REQUEST) {
                    throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
                }
                break;
            case "sucessful delete a cart":
                actor.attemptsTo(
                        Delete.from(Endpoint.CARTS_SUCCESS_PUT_DELETE)
                                .with(request -> request
                                        .relaxedHTTPSValidation()
                                        .log().all()
                                )
                );
                if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK) {
                    throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
                }
                break;
            case "failed delete a cart":
                actor.attemptsTo(
                        Delete.from(Endpoint.CARTS_FAILED)
                                .with(request -> request
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

    public static Executions service(String resources) {
        return Tasks.instrumented(Executions.class, resources);
    }
}
