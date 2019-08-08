package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://fasttrackit.org/selenium-test/wishlist/index/index/wishlist_id/163/")
public class MyWishlistPage extends PageObject {

    @FindBy(css = ".success-msg")
    private WebElementFacade successMsg;

    @FindBy(css = ".first.odd .btn-remove")
    private WebElementFacade removeItem;

    @FindBy(css = ".wishlist-empty")
    private WebElementFacade wishlistEmpty;

    public boolean successMsgIsDisplayed(){
       return successMsg.isCurrentlyVisible();
    }

    public void clickRemoveItem(){
        clickOn(removeItem);
    }

    public boolean checkWishlistIsEmpty(){
        return wishlistEmpty.isCurrentlyVisible();
    }


}
