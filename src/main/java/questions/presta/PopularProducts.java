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

package questions.presta;

import model.Product;
import model.converters.ArticleWebElementConverter;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import ui.presta.HomePage;

import java.util.List;
import java.util.stream.Collectors;

public class PopularProducts implements Question<List<Product>> {

    HomePage homePage;

    public static PopularProducts are() {
        return new PopularProducts();
    }

    @Override
    public List<Product> answeredBy(Actor actor) {
        List<Product> collect = homePage.getAllPopularProducts().stream().map(ArticleWebElementConverter::getProduct).collect(Collectors.toList());
        return collect;
    }
}