package org.fasttrack.steps;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.HomePage;
import org.fasttrack.pages.SearchResultsPage;
import org.junit.Assert;

public class SearchSteps extends PageObject {

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;


    @Step
    public void searchByItem(String item) {
        homePage.inputSearchTerm(item);
        homePage.clickSearchButton();
    }

    @Step
    public void checkProductInResults(String productName) {
        Assert.assertTrue("Product is not on page.", searchResultsPage.isProductOnPage(productName));
    }

    @Step
    public void sortProductsByCriteria(String sortBy) {
        searchResultsPage.selectSortCriteria(sortBy);
    }

    @Step
    public void verifySortingFirstWithLast(){
        Assert.assertTrue("Products are not sorted!",searchResultsPage.compareFirstWithLastProductPrices());

    }

    @Step
    public void verifySortingPriceByPrice(){
        Assert.assertTrue("Some products are not sorted!",searchResultsPage.verifyAscendingSortingPriceByPrice());
    }
}
