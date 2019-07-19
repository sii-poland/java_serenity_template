package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import ui.ToDoMvcPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class StartWith implements Task {

    public ToDoMvcPage toDoMvcPage;

    public static StartWith ToDoMvcRealTimeExample(){
        return instrumented(StartWith.class);
    }

    @Step("{0} starts ToDoMVC real time application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(toDoMvcPage));
    }
}
