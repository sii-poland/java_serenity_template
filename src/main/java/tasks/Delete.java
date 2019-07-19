package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.thucydides.core.annotations.Step;
import ui.ToDoMvcPage;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Delete implements Task {
    private List<String> todoItems;

    public Delete(List<String> todoItems) {
        this.todoItems = todoItems;
    }

    @Step("{0} deletes todo-items from the list")
    public <T extends Actor> void performAs(T actor) {
        for (String item : todoItems) {
            actor.attemptsTo(
                    JavaScriptClick.on(ToDoMvcPage.getDeleteButtonForItem(item))
            );
        }
    }

    public static Delete items(List<String> todoItems) {
        return instrumented(Delete.class, todoItems);
    }
}
