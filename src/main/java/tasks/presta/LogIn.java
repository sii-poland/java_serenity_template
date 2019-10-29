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

import abilities.Authenticate;
import abilities.CannotAuthenticateException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import ui.presta.LogInPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LogIn implements Task {

    public static LogIn wihtCredentials() {
        return instrumented(LogIn.class);
    }


    @Override
    @Step("User logs in as {0}")
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Enter.theValue(Authenticate.as(actor).withUsername()).into(LogInPage.EMAIL),
                    Enter.theValue(Authenticate.as(actor).getPassword()).into(LogInPage.PASSWORD),
                    Click.on(LogInPage.SIGN_IN_BTN)
            );
        } catch (CannotAuthenticateException e) {
            e.printStackTrace();
        }
    }
}
