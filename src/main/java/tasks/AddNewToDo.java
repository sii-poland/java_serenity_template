package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import ui.ToDoMvcPage;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddNewToDo implements Task {
    private List<String> todoItems;

    public AddNewToDo(List<String> todoItems) {
        this.todoItems = todoItems;
    }

    @Step("{0} adds todo-items to ToDo list")
    public <T extends Actor> void performAs(T actor) {
        for(String item: todoItems){
            actor.attemptsTo(
                    Enter.theValue(item).into(ToDoMvcPage.TODO_INPUT).thenHit(Keys.ENTER)
            );
        }
    }

    public static AddNewToDo items(List<String> todoItems) {
        return instrumented(AddNewToDo.class, todoItems);
    }
}
