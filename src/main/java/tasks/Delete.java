/*
 * Copyright (c) 2019. Sii Poland
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
