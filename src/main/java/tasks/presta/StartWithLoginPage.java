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

package tasks.presta;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import ui.presta.LogInPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class StartWithLoginPage implements Task {

    public LogInPage logInPage;

    public static StartWithLoginPage ToDoMvcRealTimeExample(){
        return instrumented(StartWithLoginPage.class);
    }

    @Step("{0} starts ToDoMVC real time application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(logInPage));
    }
}
