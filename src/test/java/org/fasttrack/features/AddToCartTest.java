package org.fasttrack.features;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.AddToCartSteps;
import org.fasttrack.steps.LoginSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(SerenityRunner.class)
public class AddToCartTest extends PageObject {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximiseWindow() {
        driver.manage().window().maximize();
    }

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private AddToCartSteps addToCartSteps;

    @Test
    public void addOneProductToCartAndModifyQuantity() {
        String quantity = "3";

        loginSteps.navigateToHomepage();
        addToCartSteps.navigateToVipMenu();
        addToCartSteps.performAddToCart();
        addToCartSteps.verifyAddingToCart();
        addToCartSteps.modifyQuantity(quantity);
        addToCartSteps.checkCalculation(quantity);
    }

    @Test
    public void addTreeDiferentProductsToCart() {
        int item = 0;
        int color = 0;
        int size = 0;

        loginSteps.navigateToHomepage();
        addToCartSteps.navigateToVipMenu();
        addToCartSteps.clickOnItem(item);
        addToCartSteps.selectColor(color);
        addToCartSteps.selectDesiredSize(size);
        addToCartSteps.addToCart();
        addToCartSteps.verifyAddingToCart();
        addToCartSteps.continueShopping();

        addToCartSteps.navigateToVipMenu();
        addToCartSteps.clickOnItem(item + 1);
        addToCartSteps.selectColor(color);
        addToCartSteps.selectDesiredSize(size);
        addToCartSteps.addToCart();
        addToCartSteps.verifyAddingToCart();
        addToCartSteps.continueShopping();

        addToCartSteps.navigateToVipMenu();
        addToCartSteps.clickOnItem(item + 2);
        addToCartSteps.selectColor(color + 1);
        addToCartSteps.addToCart();
        addToCartSteps.verifyAddingToCart();

        addToCartSteps.verifySum();
    }

    @Test
    public void hover() {
        loginSteps.navigateToHomepage();
        addToCartSteps.clickAccess();
    }

}
