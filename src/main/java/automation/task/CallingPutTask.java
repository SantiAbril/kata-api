package automation.task;

import automation.interactions.ExecutePost;
import automation.interactions.ExecutePut;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class CallingPutTask implements Task {

    private final String resources;
    private final String resource;

    public CallingPutTask(String resource, String resources) {
        this.resources = resources;
        this.resource = resource;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecutePut.service(resource, resources));
    }

    public static CallingPutTask service(String resource, String resources) {
        return Tasks.instrumented(CallingPutTask.class, resource, resources);
    }
}

