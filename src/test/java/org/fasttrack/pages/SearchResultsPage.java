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

    public boolean isProductOnPage(String productName) {
        for (WebElementFacade element : listOfProducts) {
            if (element.findElement(By.cssSelector(".product-name a")).getText().equals(productName))
                return true;
        }
        return false;
    }

    @FindBy(css = ".category-products > .toolbar select[title='Sort By']")
    private WebElementFacade sortCriteria;

    public void selectSortCriteria(String sortBy) {
        sortCriteria.selectByVisibleText(sortBy);
    }

    public boolean comparePrices() {

        String firstPrice = listOfProducts.get(0).findElement(By.cssSelector(".price")).getText();
//        System.out.println(firstPrice);
        String[] arrFirstPrice = firstPrice.split(",");
        String firstProductPrice = arrFirstPrice[0];

        String lastPrice = listOfProducts.get(listOfProducts.size() - 1).findElement(By.cssSelector(".price")).getText();
//        System.out.println(lastPrice);
        String[] arrLastPrice = lastPrice.split(",");
        String lastProductPrice = arrLastPrice[0];

        Integer valueFirst = Integer.valueOf(firstProductPrice);
//        System.out.println(valueFirst);
        Integer valueLast = Integer.valueOf(lastProductPrice);
//        System.out.println(valueLast);

        if (valueFirst < valueLast)
            return true;
        else
            return false;
    }


}
