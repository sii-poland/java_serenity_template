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

package ui.presta;

import net.serenitybdd.screenplay.targets.Target;

public class Article {
    public static Target ARTICLE_IMG = Target.the("Article image").locatedBy("div/a/img");
    public static Target ARTICLE_NAME = Target.the("Article name").locatedBy("div/div[@class='product-description']/h3/a");
    public static Target ARTICLE_PRICE = Target.the("Article price").locatedBy("div/div[@class='product-description']/div/span[@class='price']");

    public static Target ARTICLE_DISCOUNT = Target.the("Article discount").locatedBy("div/div/div/span[@class='discount-percentage discount-product']");
}
