package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.nio.file.WatchEvent;
import java.util.List;


public class ProductsPage extends PageObject {

    @FindBy(css = ".first > li:first-child a[title='View Details']")
    private WebElementFacade detailButton;

    @FindBy(css = ".actions .btn-cart")
    private WebElementFacade addToCartButton;

    @FindBy(css = ".add-to-cart button")
    private WebElementFacade addButton;

    @FindBy(css = "a[title='View Details']")
    private List<WebElementFacade> listOfDetailButton;

    @FindBy(css = "#configurable_swatch_color .swatch-label")
    private List<WebElementFacade> listOfColorsButton;

    @FindBy(css = "#configurable_swatch_size .swatch-label")
    private List<WebElementFacade> listOfDesiredSizeButton;

    @FindBy(css = "li:first-of-type a[href*=price]")
    private WebElementFacade firstRangeOfPrices;

    @FindBy(css = "a[href*=price]")
    private List<WebElementFacade> listOfPriceRanges;

    @FindBy(css = "span.value")
    private WebElementFacade priceRange;

    @FindBy(css = "[id|=product-price]")
    private List<WebElementFacade> listOfProductsPrices;

    @FindBy(css = ".btn-remove")
    private WebElementFacade removeFilterButton;

    public void clickDetail() {
        clickOn(detailButton);
    }

    public void clickAddToCart() {
        clickOn(addToCartButton);
    }

    public void addToCart() {
        clickOn(addButton);
    }

    public void clickOnProductDetail(int i) {
        clickOn(listOfDetailButton.get(i));
    }

    public void selectColor(int noColor) {
        clickOn(listOfColorsButton.get(noColor));
    }

    public void clickOneSize(int i) {
        clickOn(listOfDesiredSizeButton.get(i));
    }

    private int getIntPrice(String price) {
        String[] arrPrice = price.split(",");
        String finalPrice = arrPrice[0];
        int intPrice = Integer.valueOf(finalPrice);
        return intPrice;
    }

    private boolean verifyPriceInRange(String priceRange, List<WebElementFacade> pricesOfProducts) {

        String[] arrPrice = priceRange.split("[,-]");
        String lowerPrice = arrPrice[0];
        int intLowerPrice = Integer.valueOf(lowerPrice);
        int intUpperPrice;
        if (arrPrice.length > 2) {
            String upperPrice = arrPrice[2];
            intUpperPrice = Integer.valueOf(upperPrice.trim());
        } else {
            intUpperPrice = Integer.MAX_VALUE;
        }


        for (WebElementFacade prodPrice : pricesOfProducts) {
            if (getIntPrice(prodPrice.getText()) >= intLowerPrice && getIntPrice(prodPrice.getText()) <= intUpperPrice)
                return true;
        }
        return false;
    }

    public void selectFirstPriceRange() {
        clickOn(firstRangeOfPrices);
    }

    public boolean checkPrice() {
        return verifyPriceInRange(priceRange.getText(), listOfProductsPrices);
    }

    public void clickRemoveFilter() {
        clickOn(removeFilterButton);
    }

    public boolean verifyAllRanges() {

        for (int i = 0; i < listOfPriceRanges.size(); i++) {

            String priceRange = listOfPriceRanges.get(i).getText();

            clickOn(listOfPriceRanges.get(i));
            if (verifyPriceInRange(priceRange, listOfProductsPrices)) {
                clickRemoveFilter();
            } else {
                return false;
            }
        }
        return true;
    }


}
