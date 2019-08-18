package org.fasttrack.steps;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.ProductsPage;
import org.junit.Assert;

public class FilterSteps extends PageObject {

    private ProductsPage productsPage;

    @Step
    public void selectFirstPriceRange(){
        productsPage.selectFirstPriceRange();
    }

    @Step
    public void verifyShopByPrice() {
        Assert.assertTrue(productsPage.checkPrice());
    }

    @Step
    public void verifyEachRange(){
       Assert.assertTrue(productsPage.verifyAllRanges());
    }
}
