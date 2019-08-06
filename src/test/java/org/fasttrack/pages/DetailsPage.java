package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class DetailsPage extends PageObject {

    @FindBy(css = ".link-wishlist")
    private WebElementFacade addToWishlistButton;


    public void clickWishlistButton(){
        clickOn(addToWishlistButton);
    }

}
