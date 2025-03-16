package automation.exceptions;

public class ErrorServicesException extends RuntimeException {

    public static final String EXCEPTION_ERROR_CONSUMPTION_SERVICE = "Al parecer hay un error en el consumo del servicio";

    public ErrorServicesException(String exceptionMessage){
        super(exceptionMessage);
    }
}
