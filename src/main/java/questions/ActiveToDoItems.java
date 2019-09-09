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

package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.ToDoMvcPage;

import java.util.List;

public class ActiveToDoItems implements Question<List<String>> {

    public static Question<List<String>> displayed() {
        return new ActiveToDoItems();
    }

    public List<String> answeredBy(Actor actor) {
        return Text.of(ToDoMvcPage.ACTIVE_TODO_ITEMS).viewedBy(actor).asList();
    }
}

