package automation.task;

import automation.interactions.ExecuteDelete;
import automation.interactions.ExecutePut;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class CallingDeleteTask implements Task {

    private final String resources;
    private final String resource;

    public CallingDeleteTask(String resource, String resources) {
        this.resources = resources;
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteDelete.service(resource, resources));
    }

    public static CallingDeleteTask service(String resource, String resources) {
        return Tasks.instrumented(CallingDeleteTask.class, resource, resources);
    }
}
