package com.capium.automation.common;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.capium.automation.base.DriverEngine;
import com.capium.automation.base.SeleniumReusablies;


public class CommonClass extends DriverEngine {
	
	
	private static String capiumIcon = "//*[@id='collapsibleNavbar']/ul//a/span/img[@alt='capium nav logo']";
	
	private static String mobulesList1 ="//div[@id='menu-module']/div/div/ul/span/li/div/div//div/a/div[text()='";
	private static String mobulesList2 = "'])[2]";
	
	private static String moduleName = "(//*[text()='";


	

	public void navigateToPM(String entermoduleName) throws IOException {
		
		try {
		
		if (driver.findElement(By.xpath(capiumIcon)).isDisplayed() && driver.findElement(By.xpath(capiumIcon)).isEnabled()) {
			driver.findElement(By.xpath(capiumIcon)).click();
			extendreport.logInfo("Clicked on CapiumIcon");
			log.info("Clicked on CapiumIcon");
			Thread.sleep(3000);
			WebElement module = driver.findElement(By.xpath(moduleName+entermoduleName+mobulesList2));
				  //String moduleName = module.getText(); System.out.println(moduleName);	 
			if (module.isDisplayed()&&module.isEnabled()) { 
				Thread.sleep(3000);
				SeleniumReusablies.javaScript_Click(module);
				extendreport.logPass("Clicked on "+entermoduleName);
				log.info("We are in PM module");
				//module.click();
			}else {
				extendreport.logInfo("Unable to click on "+entermoduleName);
			}
		}else {
			throw new Exception();
		}
		}catch (Exception e) {
			log.info("Unable to navigate to" +entermoduleName);
			extendreport.logFail("Unable to navigate to" +entermoduleName);
			extendreport.LogFailScreenshot("Unable to navigate to" +entermoduleName);
		}
	}
	
	public void verifyLinksInWelcomePage(WebElement dashboardlink,WebElement welcomelink, WebElement link, WebElement linkPage, String linkName) throws IOException {
		try {
			SeleniumReusablies.implictyWait(100);
			dashboardlink.click();
			extendreport.logInfo("Clicked on Dashboard Link");
			log.info("Clicked on Dashboard Link");
			SeleniumReusablies.implictyWait(100);
			welcomelink.click();
			extendreport.logInfo("Clicked on Welcome Link");
			log.info("Clicked on Dashboard Link");
			Thread.sleep(2000);
			
			SeleniumReusablies.implictyWait(100);
			if (link.isDisplayed() && link.isEnabled()) {
				link.click();
				extendreport.logInfo("Clicked on "+linkName+" Link");
				log.info("Clicked on "+linkName+" Link");
				SeleniumReusablies.implictyWait(100);
				if (linkPage.isDisplayed() && linkPage.isEnabled()) {
					
					extendreport.logPass("Successfully navigate to "+linkName+" page by click on "+linkName+" link");
					log.info("Successfully navigate to "+linkName+" page by click on "+linkName+" link");
				} else {

					extendreport.logFail("Unable to navigate to "+linkName+" page by click on "+linkName+" link");
					log.info("Unable to navigate to "+linkName+" page by click on "+linkName+" link");
				}
				Thread.sleep(2000);
			}
			else 
			{
				throw new Exception();
			}
		} catch (Exception e) {
			log.info("Unable to click on "+linkName+" Link "+e.getMessage());
			extendreport.logFail("Unable to click on "+linkName+" Link");
			extendreport.LogFailScreenshot("verify"+linkName+"Link");
		}
	}
		
	}

