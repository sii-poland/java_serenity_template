package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import ui.ToDoMvcPage;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class MarkAsDone implements Task {
    private List<String> todoItems;

    public MarkAsDone(List<String> todoItems) {
        this.todoItems = todoItems;
    }

    @Step("{0} marks todo-items as done in the list")
    public <T extends Actor> void performAs(T actor) {
        for (String item : todoItems) {
            actor.attemptsTo(
                    Click.on(ToDoMvcPage.getCompletedCheckboxForItem(item))
            );
        }
    }

    public static MarkAsDone items(List<String> todoItems) {
        return instrumented(MarkAsDone.class, todoItems);
    }
}
