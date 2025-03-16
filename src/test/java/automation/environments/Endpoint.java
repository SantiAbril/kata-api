package automation.environments;

import automation.stepdefinitions.Hooks.PreliminarySteps;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;

public class Endpoint {
    public Endpoint() {
    }

    public static String setEndpoint(String path) {
        return EnvironmentSpecificConfiguration.from(PreliminarySteps.environmentVariables).getProperty(path);
    }

    public static final String CARTS = setEndpoint("carts");
    public static final String CARTS_ERROR = setEndpoint("carts_error");
}
