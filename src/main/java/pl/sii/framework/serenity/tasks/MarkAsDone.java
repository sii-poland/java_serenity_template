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

package pl.sii.framework.serenity.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import pl.sii.framework.serenity.ui.ToDoMvcPage;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class MarkAsDone implements Task {
    private List<String> todoItems;

    public MarkAsDone(List<String> todoItems) {
        this.todoItems = todoItems;
    }

    public static MarkAsDone items(List<String> todoItems) {
        return instrumented(MarkAsDone.class, todoItems);
    }

    @Step("{0} marks todo-items as done in the list")
    public <T extends Actor> void performAs(T actor) {
        for (String item : todoItems) {
            actor.attemptsTo(
                    Click.on(ToDoMvcPage.getCompletedCheckboxForItem(item))
            );
        }
    }
}
