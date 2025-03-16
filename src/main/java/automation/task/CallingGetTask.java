package automation.task;

import automation.interactions.ExecuteGet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class CallingGetTask implements Task {

    private final String resources;
    private final String resource;

    public CallingGetTask(String resource, String resources) {
        this.resources = resources;
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteGet.service(resource, resources));
    }

    public static CallingGetTask service(String resource, String resources) {
        return Tasks.instrumented(CallingGetTask.class, resource, resources);
    }
}
