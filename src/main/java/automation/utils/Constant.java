package automation.utils;

import net.serenitybdd.screenplay.Actor;

public class Constant {
    private Constant() {

    }

    public static final Actor COMMON_ACTOR = Actor.named("Santiago");
    public static final String EXCEPTION_ERROR_CONSUMPTION_SERVICE = "Al parecer hay un error en el consumo del servicio";
    public static final String VALIDATION_STATUS_CODE_200 = "Código de estado 200 en la respuesta de la API del servicio.";
    public static final String VALIDATION_STATUS_CODE_400 = "Código de estado 400 en la respuesta de la API del servicio.";

}
