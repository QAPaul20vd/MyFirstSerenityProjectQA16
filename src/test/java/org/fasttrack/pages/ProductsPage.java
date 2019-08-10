package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;

import java.nio.file.WatchEvent;
import java.util.List;


public class ProductsPage extends PageObject {

    @FindBy(css = ".first > li:first-child a[title='View Details']")
    private WebElementFacade detailButton;

    @FindBy (css = ".actions .btn-cart")
    private WebElementFacade addToCartButton;

    @FindBy(css = ".add-to-cart button")
    private WebElementFacade addButton;

    @FindBy(css = "a[title='View Details']")
    private List<WebElementFacade> listOfDetailButton;

    @FindBy(css = "#configurable_swatch_color .swatch-label")
    private List<WebElementFacade> listOfColorsButton;

    @FindBy(css= "#configurable_swatch_size .swatch-label")
    private List<WebElementFacade> listOfDesiredSizeButton;

    public void clickDetail(){
        clickOn(detailButton);
    }

    public void clickAddToCart(){
        clickOn(addToCartButton);
    }

    public void addToCart(){
        clickOn(addButton);
    }

    public void clickOnProductDetail(int i){
        clickOn(listOfDetailButton.get(i));
    }

    public void selectColor(int noColor){
        clickOn(listOfColorsButton.get(noColor));
    }

    public void clickOneSize(int i){
        clickOn(listOfDesiredSizeButton.get(i));

    }


}
