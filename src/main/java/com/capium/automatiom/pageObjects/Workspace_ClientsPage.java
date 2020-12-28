package com.capium.automatiom.pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capium.automation.base.DriverEngine;
import com.capium.automation.base.SeleniumReusablies;

public class Workspace_ClientsPage extends DriverEngine {

	public Workspace_ClientsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Dashboard xpath
	@FindBy(xpath = "//div[@id='collapsibleNavbar']//a[text()='Workspace']")
	public WebElement welement_workspace;

	@FindBy(xpath = "//div[@id='collapsibleNavbar']/ul/li/ul/li/a[text()='Clients']")
	public WebElement welement_clients;

	@FindBy(xpath = "//div[@id='clientsList']//button[text()='NEW CLIENT']")
	public WebElement welement_newClientBtng;

	// xpath for Client ID
	@FindBy(xpath = "//div[@id='contactInfo']//div[@class='modal-content']//label[text()='Client ID *']//following::div/input[@type='text']")
	public WebElement welement_clientID;
	// *[@id='contactInfo']/div/div/div[2]/form/div[1]/div/input

	// xpath for Client Name
	@FindBy(xpath = "//*[@id='contactInfo']/div/div/div[2]/form/div[2]/div/div/input")
	public WebElement welement_clientName;

	// xpath for Client Type
	@FindBy(xpath = "//*[@id='contactInfo']/div/div/div[2]/form/div[3]/div/select")
	public WebElement welement_clientTypefield;

	// xpath for Client Type
	@FindAll(@FindBy(xpath = "//*[@id='contactInfo']/div/div/div[2]/form/div[3]/div/select/option"))
	public List<WebElement> welement_clientTypes;

	// xpath for Registration number
	@FindBy(xpath = "//*[@id='contactInfo']/div/div/div[2]/form/div[4]/div/input")
	public WebElement welement_registrationNumber;

	// xpath Client Email ID
	@FindBy(xpath = "//*[@id='contactInfo']/div/div/div[2]/form/div[5]/div/input")
	public WebElement welement_clientEmailID;

	// xpath for Client Phonenumber
	@FindBy(xpath = "//*[@id='contactInfo']/div/div/div[2]/form/div[6]/div/input")
	public WebElement welement_clientPhoneNumber;

	// CSS selector for Contact Name
	@FindBy(xpath = "//*[@id='contactInfo']/div/div/div[2]/form/div[7]/div/input")
	public WebElement welement_contactName;

	// CSS selector for Contact Email ID
	@FindBy(css = "#contactInfo > div > div > div.modal-body.client-page > form > div:nth-child(8) > div > input")
	public WebElement welement_contactEmailID;

	// CSS selector for Contact Phonenumber
	@FindBy(css = "#contactInfo > div > div > div.modal-body.client-page > form > div:nth-child(9) > div > input")
	public WebElement welement_contactPhonenumber;

	// CSS selector for Save button
	@FindBy(xpath = "//button[text()=' Save ']")
	public WebElement welement_saveBtng;

	// xpath for Client ID after we create client
	@FindBy(xpath = "//*[@id='clientsList']/div[4]/div/p-table/div/div/table/tbody/tr[1]/td[4]/span/p")
	public WebElement clientIDAfterCreateClient;

	// This method to click on workspace link
	public Workspace_ClientsPage click_WorkspaceLink() throws IOException {
		try {
			if (welement_workspace.isDisplayed() && welement_workspace.isEnabled()) {
				welement_workspace.click();
				Thread.sleep(2000);
				extendreport.logPass("Clicked on Workspace link");
				log.info("Clicked on Workspace link");
			}else {
				throw new Exception();
			}

		} catch (Exception e) {
			log.info("Unable to click on Workspace link ");
			extendreport.logFail("Unable to click on Workspace link");
			extendreport.LogFailScreenshot("clickWorkspaceLink");
		}
		return new Workspace_ClientsPage(driver);
	}

	// This method to click on Clients link
	public Workspace_ClientsPage click_ClientsLink() throws IOException {
		try {
			if (welement_clients.isDisplayed() && welement_clients.isEnabled()) {
				welement_clients.click();
				Thread.sleep(3000);
				extendreport.logPass("Clicked on Clients link");
				log.info("Clicked on Clients link");
			}
		} catch (Exception e) {
			log.info("Unable to click on Clients link");
			extendreport.logFail("Unable to click on Clients link");
			extendreport.LogFailScreenshot("clickClientsLink");
		}
		return new Workspace_ClientsPage(driver);
	}

	// This method to click on New Client button
	public Workspace_ClientsPage clickOnNewClientButton() throws IOException {
		try {
			if (welement_newClientBtng.isDisplayed() && welement_newClientBtng.isEnabled()) {
				welement_newClientBtng.click();
				Thread.sleep(1000);
				extendreport.logPass("Clicked on NewClient button");
				log.info("Clicked on Clients link");
			}
		} catch (Exception e) {
			log.info("Unable to click on NewClient button");
			extendreport.logFail("Unable to click on NewClient button");
			extendreport.LogFailScreenshot("clickOnNewClientButton");
		}
		return new Workspace_ClientsPage(driver);
	}

	public Workspace_ClientsPage enterClientID(String clientid) throws IOException {

		SeleniumReusablies.enterDataByWebelement(welement_clientID, clientid, "ClientID");

		return new Workspace_ClientsPage(driver);
	}

	public Workspace_ClientsPage enterClientName(String clientname) throws IOException {
		// try {
		SeleniumReusablies.enterDataByWebelement(welement_clientName, clientname, "Client Name");
		/*
		 * } catch (Exception e) {
		 * log.info("Unable to enter data into field Client Name "+e.getMessage());
		 * extendreport.logFail("Unable to enter data into field Client Name",
		 * e.getMessage()); extendreport.LogFailScreenshot("EnterClientName"); }
		 */
		return new Workspace_ClientsPage(driver);
	}

	public Workspace_ClientsPage selectClientType(String dropdownvalue) throws IOException, InterruptedException {
		// try {
		SeleniumReusablies.selectElement(welement_clientTypefield, welement_clientTypes, dropdownvalue, "Client Type");
		/*
		 * } catch (Exception e) {
		 * log.info("Unable to select value into field Client type "+e.getMessage());
		 * extendreport.logFail("Unable to select value into field Client type",
		 * e.getMessage()); extendreport.LogFailScreenshot("selectClientType"); }
		 */
		return new Workspace_ClientsPage(driver);

	}

	public Workspace_ClientsPage enterRegistrationNumber(String registrationnumber) throws IOException {

		SeleniumReusablies.enterDataByWebelement(welement_registrationNumber, registrationnumber, "RegistrationNumber");
		return new Workspace_ClientsPage(driver);
	}

	public Workspace_ClientsPage enterClientEmailID(String clientemailid) throws IOException {

		SeleniumReusablies.enterDataByWebelement(welement_clientEmailID, clientemailid, "Client EmailID");
		return new Workspace_ClientsPage(driver);
	}

	public Workspace_ClientsPage enterClientPhoneNumber(String clientphonennumber) throws IOException {

		SeleniumReusablies.enterDataByWebelement(welement_clientPhoneNumber, clientphonennumber, "Client Phone Number");
		return new Workspace_ClientsPage(driver);
	}

	public Workspace_ClientsPage enterContactName(String contactname) throws IOException, InterruptedException {

		SeleniumReusablies.enterDataByWebelement(welement_contactName, contactname, "Contact Name");
		return new Workspace_ClientsPage(driver);
	}

	public Workspace_ClientsPage enterContactEmailID(String contactemailid) throws IOException {

		SeleniumReusablies.enterDataByWebelement(welement_contactEmailID, contactemailid, "Contact EmailID");
		return new Workspace_ClientsPage(driver);
	}

	public Workspace_ClientsPage enterContactPhoneNumber(String contactphonennumber) throws IOException, InterruptedException {

		SeleniumReusablies.enterDataByWebelement(welement_contactPhonenumber, contactphonennumber, "Contact Phone Number");
		SeleniumReusablies.scroll_Vertical();
		return new Workspace_ClientsPage(driver);
	}

	public void click_SaveBtng() throws IOException, InterruptedException {

		//SeleniumReusablies.clickElementByWebElement(welement_saveBtng, "Save Button");
		SeleniumReusablies.javaScript_ClickByWebElement(welement_saveBtng, "Save Button");
		Thread.sleep(20000);

	}

	// This method is to validate client created or not by comparing with Text at
	// webelement
	public void validateCreatedClient(String entredClientIDText) throws IOException {
		//SeleniumReusablies.explict_wait_till_visibilityOf(clientIDAfterCreateClient);
		SeleniumReusablies.validateElementWithText(clientIDAfterCreateClient, entredClientIDText, "Client ID");

	}

	/*
	 * // This method is to validate client created or not public void
	 * validateCreatedClient() throws IOException { try {
	 * SeleniumReusablies.validateElementDisplayOrNot(clientIDAfterCreateClient,
	 * "Client ID"); } catch (Exception e) { log.info("Unable to find webelement " +
	 * e.getMessage()); extendreport.logFail("Unable to find webelement ",
	 * e.getMessage()); extendreport.LogFailScreenshot("validateCreatedClient"); } }
	 */

}
