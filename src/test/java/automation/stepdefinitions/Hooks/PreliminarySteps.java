package automation.stepdefinitions.Hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static automation.utils.Constant.COMMON_ACTOR;

public class PreliminarySteps {

    public static EnvironmentVariables environmentVariables;

    @Before
    public void preliminarySteps() {

        OnStage.setTheStage(new OnlineCast());
        String theRestApiBaseUrl = environmentVariables.getProperty("environments.prod.baseurl");
        COMMON_ACTOR.whoCan(CallAnApi.at(theRestApiBaseUrl));
    }
}
