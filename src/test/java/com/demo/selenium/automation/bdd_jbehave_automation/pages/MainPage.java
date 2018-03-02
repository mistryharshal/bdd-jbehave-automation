package com.demo.selenium.automation.bdd_jbehave_automation.pages;

import org.openqa.selenium.WebDriver;

import com.jcabi.aspects.Loggable;

/**
 * @author Harshal Mistry
 *
 */
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;


public class MainPage extends PageObject {

	public MainPage(final WebDriver driver){
		super(driver);
	}
	
	final static String START_URL = "https://www.gov.uk/get-vehicle-information-from-dvla";
	
	@DefaultUrl(MainPage.START_URL)
	final class StartMainPage extends PageObject{
		public StartMainPage(final WebDriver driver){
			super(driver);
		}
	}

	@FindBy(xpath="//*[@id=\"get-started\"]/a")
	private WebElementFacade btnStart;

    @Loggable(Loggable.INFO)
	public void isUserOnHomePage() {
		PageObject page = new StartMainPage(getDriver());
		page.open();
	}

    @Loggable(Loggable.INFO)
	public VehicleEnquiryPage userClicksStartButton() {
    	btnStart.click();
    	return new VehicleEnquiryPage(getDriver());
	}
}