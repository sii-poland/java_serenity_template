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

package features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import questions.ActiveToDoItems;
import questions.CompletedToDoItems;
import tasks.AddNewToDo;
import tasks.MarkAsDone;
import tasks.StartWith;

import java.util.Arrays;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class WhenMarkItemAsDoneTest {
    Actor user = Actor.named("User");
    public static List<String> LIST_OF_ITEMS_TO_BE_ADDED = Arrays.asList("1 Item", "2 Item", "3 Item");

    @Managed
    public WebDriver browser;

    @Before
    public void userCanAddAFewToDoItems() {
        user.can(BrowseTheWeb.with(browser));
        givenThat(user).wasAbleTo(StartWith.ToDoMvcRealTimeExample());
        and(user).wasAbleTo(AddNewToDo.items(LIST_OF_ITEMS_TO_BE_ADDED));
    }

    @Test
    public void whenMarkAllItemsAsDone() {
        when(user).attemptsTo(MarkAsDone.items(LIST_OF_ITEMS_TO_BE_ADDED));
        then(user).should(seeThat(CompletedToDoItems.displayed(),is(LIST_OF_ITEMS_TO_BE_ADDED)));
        and(user).should(seeThat(ActiveToDoItems.displayed(),empty()));
    }
}
