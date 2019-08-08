package org.fasttrack.features;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.LoginSteps;
import org.fasttrack.steps.SearchSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchTest extends PageObject {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximiseWindow() {
        driver.manage().window().maximize();
    }

    @Steps
    private SearchSteps searchSteps;

    @Steps
    private LoginSteps loginSteps;

    private String item = "necklace";

    @Test
    public void performSearch(){
        loginSteps.navigateToHomepage();
        searchSteps.searchByItem(item);
        searchSteps.checkProductInResults("LUDLOW SHEATH DRESS");
    }



}
