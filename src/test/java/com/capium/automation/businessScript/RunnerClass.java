package com.capium.automation.businessScript;

import org.testng.annotations.Test;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.SocketException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capium.automatiom.pageObjects.Dashboard_WelcomePage;
import com.capium.automatiom.pageObjects.LoginPage;
import com.capium.automatiom.pageObjects.Workspace_ClientsPage;
import com.capium.automation.base.DriverEngine;
import com.capium.automation.base.SeleniumReusablies;
import com.capium.automation.pogoClass.FilePathsClass;
import com.capium.automation.utilities.ExcelReader;
import com.capium.automation.utilities.PropertiesReusable;

public class RunnerClass extends DriverEngine {

	PropertiesReusable config_pr;
	ExcelReader excelreader;

	@Test(retryAnalyzer = com.capium.automation.listeners.RetryListenerClass.class, priority = 1)
	public void login_InvalidDetails(Method m) throws IOException, SocketException {
		extendreport.extentTestClass(m.getName());
		try {
			config_pr = new PropertiesReusable(FilePathsClass.getconfig_prFilepath());
			
			excelreader = new ExcelReader(FilePathsClass.getExcelFilepath());
			

			SeleniumReusablies.OpenUrl(config_pr.getPropertyValue("url"));
			
			LoginPage loginpage = new LoginPage(driver);
			loginpage.enterUserName(config_pr.getPropertyValue("invalid_userName"));
			
			loginpage.enterPassword(SeleniumReusablies.decryptPassword(config_pr.getPropertyValue("invalid_Pwd")));
			
			loginpage.clickSignIn();
			
			SeleniumReusablies.implictyWait(100);
			loginpage.verifyInvalidLogin(config_pr.getPropertyValue("errormessage"));
			
			SeleniumReusablies.implictyWait(100);

		} catch (Exception e) {
			extendreport.logFail("We have exception in login_InvalidDetails method");
		} finally {
			extendreport.closeExtentTest();
		}
	}

	@Test(retryAnalyzer = com.capium.automation.listeners.RetryListenerClass.class, priority = 2)
	public void login_ValidDetails(Method m) throws IOException, SocketException {
		extendreport.extentTestClass(m.getName());
		try {
			
			LoginPage loginpage = new LoginPage(driver);
			loginpage.enterUserName(config_pr.getPropertyValue("userName"));
			
			loginpage.enterPassword(SeleniumReusablies.decryptPassword(config_pr.getPropertyValue("Pwd")));
			
			loginpage.clickSignIn();
			
			Thread.sleep(12000);
			//SeleniumReusablies.implictyWait(100);
			loginpage.verifyLogin();
			
			//SeleniumReusablies.implictyWait(100);
			Thread.sleep(8000);
			
			commonclass.navigateToPM("Practice Management");
			
			
			Thread.sleep(20000);

		} catch (Exception e) {
			log.info(e.getMessage());
			extendreport.logFail("We have exception in login_ValidDetails method");
		} finally {
			extendreport.closeExtentTest();
		}
	}
	
	
	
	@Test(retryAnalyzer = com.capium.automation.listeners.RetryListenerClass.class, priority = 3, enabled = false)
	public void validating_Links_In_WelcomePage(Method m) throws IOException, SocketException {
		extendreport.extentTestClass(m.getName());
		try {

			Dashboard_WelcomePage dashboardwelcomepage = new Dashboard_WelcomePage(driver);
			dashboardwelcomepage.verifyClientsLink();
	
			dashboardwelcomepage.verifyDeadlinesLink();
			
			dashboardwelcomepage.verifyDeadlinesByStatusLink();
			
			dashboardwelcomepage.verifyTaskByPriorityLink();
			

		} catch (Exception e) {
			log.info(e.getMessage());
			extendreport.logFail("We have exception in validating_Links_In_WelcomePage method");
		} finally {
			extendreport.closeExtentTest();
		}
}
	
	@Test(retryAnalyzer = com.capium.automation.listeners.RetryListenerClass.class, priority = 4)
	public void CreateNewClient(Method m) throws IOException, SocketException {
		extendreport.extentTestClass(m.getName());
		try {
			Workspace_ClientsPage workspace_clientspage = new Workspace_ClientsPage(driver);
			workspace_clientspage.click_WorkspaceLink();
			
			workspace_clientspage.click_ClientsLink();
			
			workspace_clientspage.clickOnNewClientButton();
			
			workspace_clientspage.enterClientID(excelreader.getCellDate("ClientDetails", 1, 0));
			
			workspace_clientspage.enterClientName(excelreader.getCellDate("ClientDetails", 1, 1));
			
			workspace_clientspage.selectClientType(excelreader.getCellDate("ClientDetails", 1, 2));
			
			workspace_clientspage.enterRegistrationNumber(excelreader.getCellDate("ClientDetails", 1, 3	));
			
			workspace_clientspage.enterClientEmailID(excelreader.getCellDate("ClientDetails", 1, 4));
			
			workspace_clientspage.enterClientPhoneNumber(excelreader.getCellDate("ClientDetails", 1, 5));
			
			workspace_clientspage.enterContactName(excelreader.getCellDate("ClientDetails", 1, 6));
			
			workspace_clientspage.enterContactEmailID(excelreader.getCellDate("ClientDetails", 1, 7));
			
			workspace_clientspage.enterContactPhoneNumber(excelreader.getCellDate("ClientDetails", 1, 8));
			
			workspace_clientspage.click_SaveBtng();
			
			workspace_clientspage.validateCreatedClient(excelreader.getCellDate("ClientDetails", 1, 0));
			
	
		} catch (Exception e) {
			log.info(e.getMessage());
			extendreport.logFail("We have exception in CreateNewClient method");
		} finally {
			extendreport.closeExtentTest();
		}
}
	
}