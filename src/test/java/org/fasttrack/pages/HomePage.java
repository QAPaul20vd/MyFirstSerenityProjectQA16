package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@DefaultUrl("https://fasttrackit.org/selenium-test/")
public class HomePage extends PageObject {

    @FindBy(css = "a[href*='customer/account'] .label")
    private WebElementFacade accountLink;

    @FindBy(css = "a[title='Log In']")
    private WebElementFacade loginLink;

    @FindBy(css = "#search")
    private WebElementFacade searchField;

    @FindBy(css = ".search-button")
    private WebElementFacade searchButton;

    @FindBy(css = ".nav-5")
    private WebElementFacade saleButton;


    @FindBy(css = ".nav-6")
    private WebElementFacade vipButton;


    public void clickAccount() {
        clickOn(accountLink);
    }

    public void clickLoginLink() {
        clickOn(loginLink);
    }

    public void inputSearchTerm(String term) {
        typeInto(searchField, term);
    }

    public void clickSearchButton() {
        clickOn(searchButton);
    }

    public void clickSale(){
        clickOn(saleButton);
    }

    public void clickVip(){
        clickOn(vipButton);
    }


//    @FindBy(css = ".nav-2")
//    private WebElementFacade menu;
//
//    @FindBy(css = ".nav-2 .nav-2-4")
//    private WebElementFacade submenu;
//
//    public void goToSubmenu(){
//        withAction().moveToElement(menu).moveToElement(submenu).click().build().perform();
//    }
}
