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

package pl.sii.framework.serenity.model.converters;

import lombok.extern.java.Log;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import pl.sii.framework.serenity.model.Product;

import java.util.Optional;

import static pl.sii.framework.serenity.ui.presta.Article.*;

@Log
public class ArticleWebElementConverter {
    public static Product getProduct(WebElementFacade article) {

        if (article.hasClass("product-miniature")) {
            Optional<WebElement> element;
            return Product.builder()
                    .imageUrl(
                            getSubElement(article, ARTICLE_IMG).get().getAttribute("src")
                    )
                    .clickableElement(
                            article.getWrappedElement()
                    )
                    .name(
                            getSubElement(article, ARTICLE_NAME).get().getText()
                    )
                    .price(
                            Double.parseDouble(getSubElement(article, ARTICLE_PRICE).get().getText().substring(1))
                    )
                    .discount(
                            (element = getSubElement(article, ARTICLE_DISCOUNT)).isPresent() ? element.get().getText() : "0"
                    )
                    .build();
        } else {
            throw new UnsupportedOperationException("Not an article element");
        }
    }

    private static Optional<WebElement> getSubElement(WebElementFacade parent, Target child) {
        try {
            return Optional.of(parent.findElement(By.xpath(child.getCssOrXPathSelector())));
        } catch (NotFoundException e) {
            log.info("Child element not found:" + child.getName());
            return Optional.empty();
        }
    }
}
