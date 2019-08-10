package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class CartPage extends PageObject {

    @FindBy(css = ".success-msg")
    private WebElementFacade confirmationMesage;

    @FindBy(css = ".cart-table input")
    private WebElementFacade inputQuantityField;

    @FindBy(css = ".product-cart-actions button")
    private WebElementFacade updateQuantityButton;

    @FindBy(css = ".product-cart-price span.price")
    private List<WebElementFacade> productPrice;

    @FindBy(css = "tbody > tr:first-child .a-right span")
    private WebElementFacade subTotal;

    @FindBy(css = ".btn-continue")
    private WebElementFacade continueShoppingButton;

    public void verifyProductIsAddedToCart() {
        confirmationMesage.shouldBeCurrentlyVisible();
    }

    public void modifyQuantity(String desiredQty) {
        inputQuantityField.clear();
        inputQuantityField.type(desiredQty);
    }

    public void updateQuantity() {
        clickOn(updateQuantityButton);
    }

    public boolean verifyModifiedQuantitySubTotal(String desiredQty) {

        String price = productPrice.get(0).getText();
        String[] arrPrice = price.split(",");
        String prodPrice = arrPrice[0];
        int priceValue = Integer.valueOf(prodPrice);

        String multipliedPrice = subTotal.getText();
        String[] arrMultipliedPrice = multipliedPrice.split(",");
        String totalPrice = arrMultipliedPrice[0];
        int totalValue = Integer.valueOf(totalPrice);

        Integer quantity = Integer.valueOf(desiredQty);

        if (priceValue * quantity == totalValue)
            return true;
        else
            return false;
    }

    public void clickContinueShopping() {
        clickOn(continueShoppingButton);
    }

    private int getIntPrice(String price) {
        String[] arrPrice = price.split(",");
        String finalPrice = arrPrice[0];
        int intPrice = Integer.valueOf(finalPrice);

        return intPrice;
    }

    public boolean verifySubtotalOfDifferentProducts() {
        int sum = 0;

        for (int i = 0; i < productPrice.size(); i++) {
            sum = sum + getIntPrice(productPrice.get(i).getText());
        }

        if (getIntPrice(subTotal.getText()) == sum)
            return true;
        return false;

    }

}
