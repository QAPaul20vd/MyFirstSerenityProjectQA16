package org.fasttrack.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.AddToCartSteps;
import org.fasttrack.steps.FilterSteps;
import org.fasttrack.steps.LoginSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class FiltersTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximiseWindow() {
        driver.manage().window().maximize();
    }

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private FilterSteps filterSteps;

    @Steps
    private AddToCartSteps addToCartSteps;

    @Test
    public void shopByPriceTest(){
        loginSteps.navigateToHomepage();
        addToCartSteps.navigateToVipMenu();
        filterSteps.selectFirstPriceRange();
        filterSteps.verifyShopByPrice();
    }

    @Test
    public void verifyEachShopByPriceTest(){
        loginSteps.navigateToHomepage();
        addToCartSteps.navigateToVipMenu();
        filterSteps.verifyEachRange();
    }
}
