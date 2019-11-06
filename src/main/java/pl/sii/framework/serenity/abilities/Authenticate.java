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

package pl.sii.framework.serenity.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

public class Authenticate implements Ability {
    private final String username;
    private final String password;

    private Authenticate(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Authenticate with(String username, String password) {
        return new Authenticate(username, password);
    }

    public static Authenticate as(Actor actor) {

        // complain if someone's asking the impossible
        if (actor.abilityTo(Authenticate.class) == null) {
            throw new CannotAuthenticateException(actor.getName() + " doesn't have Authenticate ability.");
        }

        return actor.abilityTo(Authenticate.class);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Store user credentials";
    }
}

