package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CreateAccountPage extends PageObject {

    @FindBy(css = "label.required + div")
    private List<WebElementFacade> listOfRequiredInputFields;

    @FindBy(css = ".checkbox")
    private WebElementFacade newsletterCheckbox;

    @FindBy(css = "button[title='Register']")
    private WebElementFacade registerButton;

    @FindBy(css = ".success-msg span")
    private WebElementFacade successfullyRegisterMessage;

    public void clickNewsletterCheckbox() {
        clickOn(newsletterCheckbox);
    }

    public void clickRegisterButton() {
        clickOn(registerButton);
    }

    public void isRegistered() {
        successfullyRegisterMessage.shouldContainText("Thank you for registering with Madison Island.");
    }

    public void setListOfRequiredInputFields(String firstName, String lastName, String email, String password, String confirmPassword) {

        listOfRequiredInputFields.get(0).findElement(By.cssSelector("input")).sendKeys(firstName);
        listOfRequiredInputFields.get(1).findElement(By.cssSelector("input")).sendKeys(lastName);
        listOfRequiredInputFields.get(2).findElement(By.cssSelector("input")).sendKeys(email);
        listOfRequiredInputFields.get(3).findElement(By.cssSelector("input")).sendKeys(password);
        listOfRequiredInputFields.get(4).findElement(By.cssSelector("input")).sendKeys(confirmPassword);
    }

    public boolean checkIfErrorMessageIsDisplayed() {

        for (WebElementFacade field : listOfRequiredInputFields) {
            WebElement fieldInput = field.findElement(By.cssSelector("input"));
            if (fieldInput.getAttribute("value").isEmpty()) {
                WebElement validationAdvice = field.findElement(By.cssSelector(".validation-advice"));
                if (!validationAdvice.isDisplayed())
                    return false;
            }
        }
        return true;
    }


}
