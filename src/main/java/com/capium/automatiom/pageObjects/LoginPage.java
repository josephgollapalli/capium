package com.capium.automatiom.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capium.automation.base.DriverEngine;


public class LoginPage extends DriverEngine{
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id = "txtusername")
	public WebElement userName;
	
	@FindBy(id = "txtpassword")
	public WebElement password;
	
	@FindBy(id = "btnLogin")
	public WebElement signIn;
	
	@FindBy(xpath = "//*[@id='appskin']//a[contains(@class,'navbar-brand')]")
	public WebElement pageTitle;
	
	//"//*[@id='ErrSignIn']/div"
	@FindBy(xpath = "//*[@id='ErrSignIn']/div[text()]")
	public WebElement errorMessage;
	
	
	public LoginPage enterUserName(String username) throws IOException {
		try {
		if(userName.isDisplayed() && userName.isEnabled()) {
			userName.clear();
			userName.sendKeys(username);
			extendreport.logPass("Username entered");
			log.info("User name entered");
		}
		else {
			throw new Exception();
		}
		}catch (Exception e) {
			log.info("Unable enter user name ");
			extendreport.logFail("Unable enter user name");
			extendreport.LogFailScreenshot("enterUserName");
		}
		return new LoginPage(driver);
	}
	
	public LoginPage enterPassword(String pwd) throws IOException {
		try {
		if(password.isDisplayed() && password.isEnabled()) {
			password.clear();
			password.sendKeys(pwd);
			extendreport.logPass("Password entered");
			log.info("Password entered");
		}
		else {
			throw new Exception();
		}
		}catch (Exception e) {
			log.info("Unable enter password ");
			extendreport.logFail("Unable enter password");
			extendreport.LogFailScreenshot("enterPassword");
		}
		return new LoginPage(driver);
	}
	
	public Dashboard_WelcomePage clickSignIn() throws IOException, InterruptedException {
		try {
			if (signIn.isDisplayed() && signIn.isEnabled()) {
				signIn.click();
				extendreport.logPass("SignIn button clicked");
				log.info("SignIn button clicked");
			}
			else {
				throw new Exception();
			}
		} catch (Exception e) {
			log.info("Unable click signIn button ");
			extendreport.logFail("Unable click signIn button");
			extendreport.LogFailScreenshot("clickSignIn");
		}
		return new Dashboard_WelcomePage(driver);
	}
	
	
	public Dashboard_WelcomePage verifyLogin() throws IOException {
		try {
			if (pageTitle.isDisplayed()&&pageTitle.isEnabled()) {
				extendreport.logPass("User is in the Dashboard page");
				log.info("Logged in successfully");
			}else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			log.info("Unable to validate Login ");
			extendreport.logFail("Unable to validate Login");
			extendreport.LogFailScreenshot("verifyLogin");
		}
		return new Dashboard_WelcomePage(driver);
	}
	
	public LoginPage verifyInvalidLogin(String errormessagetext) throws IOException {
		try {
			System.out.println("Error message is : "+errorMessage.getText());
			if(errorMessage.getText() == errormessagetext)
			{
				extendreport.logPass("Not able to login with invalid details");	
				log.info("Not able to login with invalid details");
			}
			else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			log.info("Able to login with invalid details ");
			extendreport.logFail("Able to login with invalid details");
			extendreport.LogFailScreenshot("verifyInvalidLogin");
		}
		return new LoginPage(driver);
	}


}
