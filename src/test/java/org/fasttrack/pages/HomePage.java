package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @FindBy(css = ".nav-primary > li > a[href*='sale']")
    private WebElementFacade saleButton;

    @FindBy(css = ".nav-primary a[href*='vip']")
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

    public void clickSale() {
        clickOn(saleButton);
    }

    public void clickVip() {
        clickOn(vipButton);
    }

    @FindBy(css = ".nav-primary >li >a[href*='accessories']")
    private WebElementFacade accessoriesButton;

    @FindBy(css = ".nav-primary > li > ul > li > a[href*='shoes']")
    private WebElementFacade shoesButton;

    public void hover(){
//        WebDriver wb = getDriver();
//        Actions action = new Actions(wb);
//        WebElement accessories = wb.findElement(By.cssSelector(".nav-primary >li >a[href*='accessories']"));
//        WebElement shoes = wb.findElement(By.cssSelector(".nav-primary > li > ul > li > a[href*='shoes']"));

//        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//        js.executeScript("arguments[0].onmouseover()", accessories);


//        action.moveToElement(accessories).perform();
//        action.moveToElement(shoes).click().build().perform();
//        action.moveToElement(accessories).click(shoes).build().perform();
        clickOn(accessoriesButton);


    }

}
