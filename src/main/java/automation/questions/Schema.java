package automation.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class Schema implements Question <Boolean>{

    private final String structure;

    public Schema(String structure) {
        this.structure = structure;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
              seeThatResponse("Validation schema service response",
                      response -> response
                              .assertThat()
                              .body(matchesJsonSchemaInClasspath("templates/"+ structure + ".json"))
              )
        );
        return true;
    }
    public static Schema esperado (String schemaResponse){
        return new Schema(schemaResponse);
    }
}
