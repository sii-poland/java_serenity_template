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

package pl.sii.framework.serenity.ui.presta;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.At;
import org.openqa.selenium.By;

import java.util.List;

@At("http://5.196.7.235/")
public class HomePage extends PageObject {
    public static final Target USERNAME = Target.the("Username in header").located(By.className("account"));
    public static final Target POPULAR_PRODUCTS = Target.the("Popular Products grid").locatedBy("//article");

    public List<WebElementFacade> getAllPopularProducts() {
        return findAll(POPULAR_PRODUCTS.getCssOrXPathSelector());
    }
}
