package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends PageObject {

    @FindBy(css = ".products-grid .item")
    private List<WebElementFacade> listOfProducts;

    @FindBy(css = ".category-products > .toolbar select[title='Sort By']")
    private WebElementFacade sortCriteria;

    @FindBy(css = ".category-products > div:first-child a[title~=Descending]")
    private WebElementFacade sortDirection;

    @FindBy(css = "[id|=product-price]")
    private List<WebElementFacade> listOfPrices;

    public boolean isProductOnPage(String productName) {
        for (WebElementFacade element : listOfProducts) {
            if (element.findElement(By.cssSelector(".product-name a")).getText().equals(productName))
                return true;
        }
        return false;
    }

    public void selectSortCriteria(String sortBy) {
        sortCriteria.selectByVisibleText(sortBy);
    }

    private int getIntPrice(String price) {
        String[] arrPrice = price.split(",");
        String finalPrice = arrPrice[0];
        int intPrice = Integer.valueOf(finalPrice);
        return intPrice;
    }

    public boolean compareFirstWithLastProductPrices() {

        int valueFirst = getIntPrice(listOfProducts.get(0).findElement(By.cssSelector(".price")).getText());
        int valueLast = getIntPrice(listOfProducts.get(listOfProducts.size() - 1).findElement(By.cssSelector(".price")).getText());

        return sortDirection.isCurrentlyVisible() && valueFirst < valueLast;
    }

    public boolean verifyAscendingSortingPriceByPrice() {
        for (int i = 0; i < listOfPrices.size() - 1; i++) {
            for (int j = i + 1; j < listOfPrices.size(); j++) {
                if (getIntPrice(listOfPrices.get(i).getText()) < getIntPrice(listOfPrices.get(j).getText()))
                    return true;
            }
        }
        return false;
    }


}
