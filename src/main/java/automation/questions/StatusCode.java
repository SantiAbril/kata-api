package automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static automation.utils.Constant.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class StatusCode implements Question<Boolean> {

    private final int code;

    public StatusCode(int code) {
        this.code =  code;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        switch (code){
            case 200:
                actor.should(
                        seeThatResponse(VALIDATION_STATUS_CODE_200,
                                response -> response
                                        .statusCode(code)
                        )
                );
                break;
            case 400 :
                actor.should(
                        seeThatResponse(VALIDATION_STATUS_CODE_400,
                                response -> response
                                        .statusCode(code)
                        )
                );
                break;
            default:
                throw new IllegalArgumentException("Codigo no reconocido: " + code);
        }
        return true;
    }

    public static StatusCode is(int statusCode) {
        return new StatusCode(statusCode);
    }
}