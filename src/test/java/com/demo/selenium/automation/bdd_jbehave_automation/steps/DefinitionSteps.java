package com.demo.selenium.automation.bdd_jbehave_automation.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


import com.demo.selenium.automation.bdd_jbehave_automation.steps.serenity.EndUserSteps;
import com.jcabi.aspects.Loggable;

import net.thucydides.core.annotations.Steps;

public class DefinitionSteps {
	
	private static int rowCounter = 0;

    @Steps
    EndUserSteps endUser;
	
    
    @Loggable(Loggable.INFO)
    @Given("a config directory with many files")
    public void giverAConfigDirectoryWithManyFiles() {
        endUser.aConfigDirectoryWithManyFiles();
    }
    
    @Loggable(Loggable.INFO)
    @When("the user scans the directory for file details using service bean")
    public void whenUserScansTheDirectoryForFileDetails() {
        endUser.whenUserScansTheDirectoryForFileDetails();
    }
    
    @Loggable(Loggable.INFO)
    @Then("all the file details under that directory are displayed")
    public void thenAllTheFileDetailsUnderThatDirectoryAreDisplayed() {
        endUser.allTheFileDetailsUnderThatDirectoryAreDisplayed();
    }
    
    @Loggable(Loggable.INFO)
    @When("the user reads the excel file $fileName for Car Registration details")
    public void whenTheUserReadsTheExcelFile(String fileName) {
        endUser.userScansTheDirectoryForFileDetails(fileName);
    }
    
    @Loggable(Loggable.INFO)
    @When("the user is on the dvla webpage")
    public void whenTheUserIsOnTheDvlaWebpage() {
        endUser.theUserIsOnTheDvlaWebpage();
    }
    
    @Loggable(Loggable.INFO)
    @When("user clicks back button")
    public void WhenUserClicksBackButton() {
        endUser.userClicksBackButton();
    }

    @Loggable(Loggable.INFO)
    @When("the user enters car details for row")
    public void WhenTheUserEntersCarDetails() {
        endUser.theUserEntersCarDetails(rowCounter++);
    }

    @Loggable(Loggable.INFO)
    @Then("the car details are validated")
    public void ThenCarDetailsAreValidated() {
        endUser.carDetailsAreValidated();
    }
    
    
    
    
    
}
