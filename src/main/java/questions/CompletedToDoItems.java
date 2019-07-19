package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.ToDoMvcPage;

import java.util.List;

public class CompletedToDoItems implements Question<List<String>> {

    public static Question<List<String>> displayed() {
        return new CompletedToDoItems();
    }

    public List<String> answeredBy(Actor actor) {
        return Text.of(ToDoMvcPage.COMPLETED_TODO_ITEMS).viewedBy(actor).asList();
    }
}

