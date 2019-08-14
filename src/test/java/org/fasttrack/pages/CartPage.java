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

    @FindBy(css = ".btn-empty")
    private WebElementFacade emptyCartButton;

    @FindBy(css = ".page-title button")
    private WebElementFacade checkoutButton;

    @FindBy(css = "h1")
    private WebElementFacade emptyCartMessage;

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

    private int getIntPrice(String price) {
        String[] arrPrice = price.split(",");
        String finalPrice = arrPrice[0];

        return Integer.valueOf(finalPrice);
    }

    public boolean verifyModifiedQuantitySubTotal(String desiredQty) {

        int priceValue = getIntPrice(productPrice.get(0).getText());
        int totalValue = getIntPrice(subTotal.getText());

        Integer quantity = Integer.valueOf(desiredQty);

        return priceValue * quantity == totalValue;
    }

    public void clickContinueShopping() {
        clickOn(continueShoppingButton);
    }

    public boolean verifySubtotalOfDifferentProducts() {
        int sum = 0;

        for (int i = 0; i < productPrice.size(); i++) {
            sum = sum + getIntPrice(productPrice.get(i).getText());
        }

        return getIntPrice(subTotal.getText()) == sum;
    }

    public void clickCheckoutButton(){
        clickOn(checkoutButton);
    }

    public void clickEmptyCartButton(){
        clickOn(emptyCartButton);
    }

    public void verifyCartIsEmpty(){
        emptyCartMessage.shouldContainText("Shopping cart is empty".toUpperCase());
    }

}
