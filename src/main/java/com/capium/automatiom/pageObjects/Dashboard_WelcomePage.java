package com.capium.automatiom.pageObjects;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capium.automation.base.DriverEngine;
import com.capium.automation.base.SeleniumReusablies;


public class Dashboard_WelcomePage extends DriverEngine {
	
	public Dashboard_WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public Dashboard_WelcomePage() {
	}

	//Dashboard xpath
	@FindBy(xpath = "//div[@id='collapsibleNavbar']//a[text()='Dashboard']")
	public WebElement dashboard;
	
	@FindBy(xpath = "//div[@id='collapsibleNavbar']/ul/li/ul/li/a[text()='Welcome']")
	public WebElement welcome;
	
	//Clients xpath
	@FindBy(xpath = "//div[contains(@class,'card-panel')]/div[@class='card-header']//a[contains(@data-tooltip,'Go to Clients Module')]/i")
	public WebElement clientsLink;
	
	//Deadlines xpath
	@FindBy(xpath = "(//div[contains(@class,'card-panel')]/div[@class='card-header']//a[contains(@data-tooltip,'Go to Deadlines Module')]/i)[1]")
	public WebElement deadlinesLink;
	
	@FindBy(xpath = "(//div[contains(@class,'card-panel')]/div[@class='card-header']//a[contains(@data-tooltip,'Go to Deadlines Module')]/i)[2]")
	public WebElement DeadlinesByStatusLink;
	
	@FindBy(xpath = "(//div[contains(@class,'card-panel')]/div[@class='card-header']//a[contains(@data-tooltip,'Go to Deadlines Module')]/i)[3]")
	public WebElement DeadlinesListLink;
	
	//Activity xpath
	@FindBy(xpath = "//div[contains(@class,'card-panel')]/div[@class='card-header']//a[contains(@tooltip,'Go to Activity Module')]/i")
	public WebElement ActivityLink;
			
	//Tasks xpath
	@FindBy(xpath = "(//div[contains(@class,'card-panel')]/div[@class='card-header']//a[contains(@data-tooltip,'Go to Tasks Module')]/i)[1]")
	public WebElement TaskByPriorityLink;
	
	@FindBy(xpath = "(//div[contains(@class,'card-panel')]/div[@class='card-header']//a[contains(@data-tooltip,'Go to Tasks Module')]/i)[2]")
	public WebElement NoofTasksLink;
	
	@FindBy(id = "clientsList")
	public WebElement clientsPage;
	
	@FindBy(xpath = "//div[@id='listView']//h4[text()='Deadlines']")
	public WebElement deadlinesPage;
	
	@FindBy(id = "TaskList")
	public WebElement tasksPage;
			
	
	//This method is to verify, on click on clients link in welcome page, It should navigate to Clients page.
	public void verifyClientsLink() throws IOException {
		try {
			if (clientsLink.isDisplayed() && clientsLink.isEnabled()) {
				clientsLink.click();
				extendreport.logInfo("Clicked on Clients Link");
				log.info("Clicked on Clients Link");
				SeleniumReusablies.implictyWait(100);
				if (clientsPage.isDisplayed() && clientsPage.isEnabled()) {
					
					extendreport.logInfo("Successfully navigate to Clients page by click on clients link");
					log.info("Successfully navigate to Clients page by click on clients link");
				} else {

					extendreport.logInfo("Unable to navigate to Clients page by click on clients link");
					log.info("Unable to navigate to Clients page by click on clients link");
				}
			}
			else 
			{
				extendreport.logInfo("Unable to click on Clients Link");
				log.info("Unable to click on Clients Link");
			}
		} catch (Exception e) {
			log.info("Unable to click on Clients Link "+e.getMessage());
			extendreport.logFail("Unable to click on Clients Link");
			extendreport.LogFailScreenshot("verifyClientsLink");
		}

	}
	
	/*
	 * public void verifyClientsLink() throws IOException { CommonClass commonclass
	 * = new CommonClass(); commonclass.verifyLinksInWelcomePage(clientsLink,
	 * clientsPage, "Clients"); }
	 */
	
	//This method is to verify, on click on deadlines link in welcome page, It should navigate to Deadlines page.
	public void verifyDeadlinesLink() throws IOException {
		super.commonclass.verifyLinksInWelcomePage(dashboard, welcome, deadlinesLink, deadlinesPage, "Deadlines");
		
	}
	
	
	//This method is to verify, on click on deadlines by status link in welcome page, It should navigate to Deadlines page.
	public void verifyDeadlinesByStatusLink() throws IOException {
		commonclass.verifyLinksInWelcomePage(dashboard, welcome, DeadlinesByStatusLink, deadlinesPage, "DeadlinesByStatusLink");
	}
	
	/*
	 * public void verifyActivityLink() throws IOException {
	 * commonclass.verifyLinksInWelcomePage(dashboard, ActivityLink, "",
	 * "ActivityLink"); }
	 */
	
	//This method is to verify, on click on deadlines link in welcome page, It should navigate to Deadlines page.
	public void verifyTaskByPriorityLink() throws IOException {
		commonclass.verifyLinksInWelcomePage(dashboard, welcome, TaskByPriorityLink, tasksPage, "TaskByPriorityLink");
	}
	
	/*
	public void enterUserName(String username) throws IOException {
		try {
		if(userName.isDisplayed() && userName.isEnabled()) {
			userName.sendKeys(username);
			r.logInfo("Username entered");
		}
		}catch (Exception e) {
			r.logFail("Unable enter user name", e.getMessage());
			r.LogFailScreenshot("enterUserName");
		}
	}*/

}
