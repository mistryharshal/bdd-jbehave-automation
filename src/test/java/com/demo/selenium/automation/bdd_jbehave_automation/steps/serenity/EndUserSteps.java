package com.demo.selenium.automation.bdd_jbehave_automation.steps.serenity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.selenium.automation.bdd_jbehave_automation.pages.ConfirmVehicle;
import com.demo.selenium.automation.bdd_jbehave_automation.pages.MainPage;
import com.demo.selenium.automation.bdd_jbehave_automation.pages.VehicleEnquiryPage;
import com.id.e2e.bean.FileInfoServiceBean;
import com.jcabi.aspects.Loggable;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class EndUserSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2863126367800874621L;
	MainPage mainPage;
	VehicleEnquiryPage vehicleEnquiryPage;
	ConfirmVehicle confirmVehicle;
	
    static String directoryName;
    private static Map<String, String> dataMap = new HashMap<>();
    FileInfoServiceBean fileInfoServiceBean;
	private ApplicationContext context;
	private Object[] regValues;
	private Object[] colourValues;
	private String RegNumber;
	private String ColourVal;


	@Loggable(Loggable.INFO)
	@Step
	public void aConfigDirectoryWithManyFiles() {
		Properties prop = new Properties();
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));

			// get the property value and print it out
			System.out.println("**** Config directory : " + prop.getProperty("TestDirectory"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}	
		directoryName = prop.getProperty("TestDirectory");
		System.out.println("Test Directory Name and Path Whose Details Needed: " + System.getProperty("user.dir") + "\\"
				+ directoryName);
	}

	@Loggable(Loggable.INFO)
	@Step
	public void whenUserScansTheDirectoryForFileDetails() {
        context = new ClassPathXmlApplicationContext(
                "Spring-Module.xml");
        fileInfoServiceBean = (FileInfoServiceBean) context.getBean("FileInfoBean");
	}

	@Loggable(Loggable.INFO)
	@Step
	public void allTheFileDetailsUnderThatDirectoryAreDisplayed() {
		fileInfoServiceBean.printAllFileDetailsInDirectory(directoryName);
	}

	@Loggable(Loggable.INFO)
	@Step
	public void userScansTheDirectoryForFileDetails(String fileName) {
        dataMap = fileInfoServiceBean.retrieveCsvData(System.getProperty("user.dir")+ "\\"+directoryName+"\\"+fileName);
        System.out.println("D: "+  fileName);
        System.out.println("D: "+  dataMap);        
        
        regValues = dataMap.keySet().toArray();
        colourValues = dataMap.keySet().toArray();
        
/*        System.out.println("Data from CSV/Excel : "+  dataMap.get(regValues[1]));
        System.out.println("Data from CSV/Excel : "+  colourValues[2].toString());
        System.out.println("Data from 22222222222 : "+  colourValues);
        System.out.println("Data from 4444444 : "+  dataMap);*/
	}
	
	@Loggable(Loggable.INFO)
	@Step
	public void theUserIsOnTheDvlaWebpage() {
		mainPage.isUserOnHomePage();
		mainPage.userClicksStartButton();
	}

	@Loggable(Loggable.INFO)
	@Step
	public void theUserEntersCarDetails(int row) {
		RegNumber = regValues[row].toString();
		ColourVal = dataMap.get(colourValues[row]);
		vehicleEnquiryPage.enterRegNumber(RegNumber);

	}

	@Loggable(Loggable.INFO)
	@Step
	public void carDetailsAreValidated() {
		confirmVehicle.aseertconfirmVehicleDetasile(RegNumber, ColourVal);
	}

	@Loggable(Loggable.INFO)
	@Step
	public void userClicksBackButton() {
		confirmVehicle.userClicksBackButton();
	}
}