package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://fasttrackit.org/selenium-test")

public class SalePage extends PageObject {

    @FindBy(css = ".nav-5")
    private WebElementFacade saleButton;


    public void clickSale(){
        clickOn(saleButton);
    }

}
