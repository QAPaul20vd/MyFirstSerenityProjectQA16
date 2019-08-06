package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("https://fasttrackit.org/selenium-test/sale.html")
public class ProductsPage extends PageObject {

    @FindBy(css = ".first > li:first-child a[title='View Details']")
    private WebElementFacade detailButton;


    public void clickDetail(){
        clickOn(detailButton);
    }

}
