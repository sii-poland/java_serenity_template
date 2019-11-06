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

package pl.sii.features.presta;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pl.sii.framework.serenity.abilities.Authenticate;
import pl.sii.framework.serenity.model.PrestaUser;
import pl.sii.framework.serenity.questions.presta.DisplayedUserName;
import pl.sii.framework.serenity.questions.presta.PopularProducts;
import pl.sii.framework.serenity.tasks.presta.LogIn;
import pl.sii.framework.serenity.tasks.presta.StartPresta;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class WhenRegisteredUserLogsInSimpleTest {

    private final PrestaUser prestaUser = PrestaUser.builder()
            .email("tkuran@sii.pl")
            .name("Tom Kuran")
            .password("p@ssword").build();

    private final Actor user = Actor.named(prestaUser.getName());

    @Managed
    private WebDriver browser;


    @Before
    public void userCanBrowseAsAuthenticatedClient() {
        user.can(BrowseTheWeb.with(browser));
        user.can(Authenticate.with(prestaUser.getEmail(), prestaUser.getPassword()));
    }

    @Test
    public void whenLoggingInAsClient() {
        givenThat(user).wasAbleTo(StartPresta.onLoginPage());
        when(user).attemptsTo(LogIn.wihtCredentials());
        then(user).should(seeThat(DisplayedUserName.is(), is(prestaUser.getName())));
    }
}
