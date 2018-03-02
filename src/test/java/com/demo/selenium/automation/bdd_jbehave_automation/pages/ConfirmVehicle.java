package com.demo.selenium.automation.bdd_jbehave_automation.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.jcabi.aspects.Loggable;

/**
 * @author Harshal Mistry
 *
 */
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;


public class ConfirmVehicle extends PageObject {

    public ConfirmVehicle(final WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//*[@id=\"pr3\"]/div/ul/li[1]/span[2]")
    private WebElementFacade lblRegNum;
    
    @FindBy(xpath="//*[@id=\"pr3\"]/div/ul/li[3]/span[2]/strong")
    private WebElementFacade lblColour;

    @FindBy(xpath="//*[@id=\"content\"]/div[2]/a")
	private WebElementFacade btnBack;

    @Loggable(Loggable.INFO)
	public void aseertconfirmVehicleDetasile(String regNumber, String colour) {
    	System.out.println(lblRegNum.getText().trim());
    	System.out.println(regNumber);
    	System.out.println(lblColour.getText().trim());
    	assertTrue("Car Reg Number does not match", regNumber.contentEquals(lblRegNum.getText().trim()));
    	assertTrue("Car Colour does not match", colour.contentEquals(lblColour.getText().trim()));
	}

    @Loggable(Loggable.INFO)
	public VehicleEnquiryPage userClicksBackButton() {
		//btnBack.click();
		getDriver().navigate().back();
		//getDriver().navigate().refresh();
		return new VehicleEnquiryPage(getDriver());
	}

}