package com.demo.selenium.automation.bdd_jbehave_automation.pages;

import org.openqa.selenium.WebDriver;

import com.jcabi.aspects.Loggable;

/**
 * @author Harshal Mistry
 *
 */
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;


public class VehicleEnquiryPage extends PageObject {

	public VehicleEnquiryPage(final WebDriver driver){
		super(driver);
	}

	@FindBy(id="Vrm")
	private WebElementFacade txtBoxRegistrationNo;

	@FindBy(css="#content form div div div.form-group.no-bottom fieldset button")
	private WebElementFacade btnContinue;

    @Loggable(Loggable.INFO)
	public void userEntersRegistrationNumber(String numberplate) {
		txtBoxRegistrationNo.sendKeys(numberplate);
	}

	@Loggable(Loggable.INFO)
	public ConfirmVehicle userClicksContinueButton() {
		btnContinue.click();
		return new ConfirmVehicle(getDriver());
	}

	@Loggable(Loggable.INFO)
	public void enterRegNumber(String regNumber) {
		userEntersRegistrationNumber(regNumber);
		userClicksContinueButton();
	}

}