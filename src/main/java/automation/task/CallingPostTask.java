package automation.task;

import automation.interactions.ExecutePost;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class CallingPostTask implements Task {

    private final String resources;
    private final String resource;

    public CallingPostTask(String resource, String resources) {
        this.resources = resources;
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecutePost.service(resource, resources));
    }

    public static CallingPostTask service(String resource, String resources) {
        return Tasks.instrumented(CallingPostTask.class, resource, resources);
    }
}
