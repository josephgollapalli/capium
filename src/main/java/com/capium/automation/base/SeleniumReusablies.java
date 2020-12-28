package com.capium.automation.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;





public class SeleniumReusablies extends DriverEngine {
	static JavascriptExecutor js = ((JavascriptExecutor) driver);
	
	static Actions actions = new Actions(driver) ;
	

	public static void OpenUrl(String url) {
		driver.get(url);
		extendreport.logInfo("Url opened");
		log.info("User name entered");
	}

	public static void highLightById(String id) {
		WebElement ele = driver.findElement(By.id(id));
		js.executeScript("arguments[0].style.border='3px solid red';", ele);
	}

	public static void highLightByXpath(String xpath) {
		WebElement ele = driver.findElement(By.xpath(xpath));
		js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red';", ele);
	}

	public static void highLightElement(WebElement ele) {
		js.executeScript("arguments[0].style.border='3px solid red';", ele);
	}

	public static void enterElementById(String id, String data) {
		try {
			WebElement element = driver.findElement(By.id(id));
			if (element.isDisplayed() && element.isEnabled()) {
				highLightById(id);
				element.clear();
				element.sendKeys(data);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void enterElementByXpath(String xpath, String data) {
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			if (element.isDisplayed() && element.isEnabled()) {
				highLightByXpath(xpath);
				element.clear();
				element.sendKeys(data);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	// This method is to enter date on element by passing webelement
	public static void enterDataByWebelement(WebElement element, String data, String fieldName) throws IOException {
		try {
			if (element.isDisplayed() && element.isEnabled()) {
				element.clear();
				element.sendKeys(data);
				extendreport.logPass("Entered data in field " + fieldName);
				log.info("Entered data in field " + fieldName);
			}
			else {
				throw new Exception();
			}

		} catch (Exception e) {
			log.info("Unable to enter data in field " + fieldName);
			extendreport.logFail("Unable to enter data into field " + fieldName);
			extendreport.LogFailScreenshot("ClickElement" + fieldName);
		}

	}
	
	//This method is select value from dropdowm by comparing with given text and with dropdown values
	public static void selectElement(WebElement element, List<WebElement> options, String dropdownvalue, String fieldName) throws InterruptedException, IOException {
		try {	
		List<WebElement> values = options;
			if (element.isDisplayed() && element.isEnabled()) {
				element.click();
				Thread.sleep(1000);
				extendreport.logInfo("Clicked on dropdown "+fieldName);
				log.info("Clicked on dropdown "+fieldName);
				for (WebElement value : values) {
					if (value.getText().equalsIgnoreCase(dropdownvalue)) {
						value.click();
						Thread.sleep(1000);
						extendreport.logPass("Selected the dropdown value "+dropdownvalue);
						log.info("Selected the dropdown value "+dropdownvalue);
					}
					else {
						throw new Exception();
					}
				}
			}
			else {
				throw new Exception();
			}
	} catch (Exception e) {
		
		  log.info("Unable to select data in dropdown field "+fieldName);
		  extendreport.logFail("Unable to selcet data into dropdown field "+fieldName); 
		  extendreport.LogFailScreenshot("Select"+fieldName);
		 
	}
	}
	
	//This method is to Click on element by passing webelement
	public static void clickElementByWebElement(WebElement element,String fieldName) throws InterruptedException, IOException {
		try {	
		if (element.isDisplayed() && element.isEnabled()) {
				element.click();
				Thread.sleep(3000);
				extendreport.logInfo("Clicked on field "+fieldName);
				log.info("Clicked on field "+fieldName);
			}
	} catch (Exception e) {
		log.info("Unable to click on element "+e.getMessage());
		extendreport.logFail("Unable to click on element "+fieldName);
		extendreport.LogFailScreenshot("click"+fieldName);
	}
	}
	
	//This method is to validate client created or not
	public static void validateElementDisplayOrNot(WebElement element, String fieldName) throws IOException {
		try{
		if (element.isDisplayed() && element.isEnabled()) {
			SeleniumReusablies.highLightElement(element);
			extendreport.logPass("WebElement "+fieldName+" displayed");
			log.info("WebElement "+fieldName+" displayed");
		}
		else {
			throw new Exception();
		}
	} catch (Exception e) {
		log.info("Unable to find webelement "+fieldName); 
		extendreport.logFail("Unable to find webelement "+fieldName); 
		extendreport.LogFailScreenshot("validateElementDisplayOrNot_"+fieldName);
	}
}
	
	//This method is to validate client created or not by comparing with Text at weblement
	public static void validateElementWithText(WebElement element,String text, String fieldName) throws IOException {
		try {
			if (element.getText().equalsIgnoreCase(text)) {
				SeleniumReusablies.highLightElement(element);
				extendreport.logPass("WebElement text matched with "+text+" at "+fieldName+" field");
				log.info("WebElement text matched with "+text+" at "+fieldName+" field");
			}
	} catch (Exception e) {
		log.info("Unable to find webelement "+fieldName);
		extendreport.logFail("Unable to find webelement "+fieldName);
		extendreport.LogFailScreenshot("validateElementWithText_"+fieldName);
	}
}

	public static void clickElementById(String id) {
		try {
			WebElement element = driver.findElement(By.id(id));
			if (element.isDisplayed() && element.isEnabled()) {
				highLightById(id);
				element.click();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void enterElementByxpath(String xpath, String data) {
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			if (element.isDisplayed() && element.isEnabled()) {
				highLightByXpath(xpath);
				element.clear();
				element.sendKeys(data);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	public static WebElement findElementByxpath(String xpath) {
			WebElement element = driver.findElement(By.xpath(xpath));
				return element;
	}
	
	public static String  takeScreenshot(String methodName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/"+methodName+dateName+".png";
		FileUtils.copyFile(srcFile, new File(destination));
		return destination;
	}

	public static void implictyWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	
	public static void click_Esc()
	{
		actions.sendKeys(Keys.ESCAPE).build().perform();
	}

	
	public static  void explict_wait_till_visibilityOf(WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, 20000);
//			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}
	
	
	public static  void explict_wait_till_visibilityOfAllElements(List<WebElement> elements) {
		try {
		
			WebDriverWait wait = new WebDriverWait(driver, 1000);
//			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		}
		catch(Exception e)
		{
			System.out.println(elements + "Element not present");
			
		}
		
	}
	public static void fluent_wait() {
		new FluentWait<WebDriver>(driver)
				.withTimeout(500, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS)
				.ignoring(StaleElementReferenceException.class);

	}

	public static void javaScript_ClickByWebElement(WebElement element, String fieldName) throws IOException {
		try {
			if (element.isDisplayed() && element.isEnabled()) {
			js.executeScript("arguments[0].click();", element);
			Thread.sleep(3000);
			extendreport.logInfo("Clicked on field " + fieldName);
			log.info("Clicked on field " + fieldName);
			}else {
				throw new Exception();
				//throw new SeleniumException(e);
			}
		} catch (Exception e) {
			log.info("Unable to click on element "+fieldName);
			extendreport.logFail("Unable to click on element "+ fieldName);
			extendreport.LogFailScreenshot("click" + fieldName);
		}

	}
	
	public static void javaScript_Click(WebElement element) throws InterruptedException
	{
		js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
	}
	
	public static  void scroll_Vertical() throws InterruptedException {
		js = ((JavascriptExecutor)driver);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,150)", "");
		
	}
	
	public static String decryptPassword(String encodedBytes) {
		byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
		return new String(decodedBytes);
	}
	
	
	
	
}
