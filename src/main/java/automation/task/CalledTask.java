package automation.task;

import automation.interactions.Executions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class CalledTask implements Task {

    private final String resources;

    public CalledTask(String resources) {
        this.resources = resources;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Executions.service(resources));
    }

    public static CalledTask service(String resources) {
        return Tasks.instrumented(CalledTask.class, resources);
    }
}
