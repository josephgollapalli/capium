package com.capium.automation.base;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.capium.automation.common.CommonClass;
import com.capium.automation.pogoClass.FilePathsClass;
import com.capium.automation.reports.Report;

public class DriverEngine 
{
	 public static WebDriver driver;
	 protected static Report extendreport = new Report();
	 protected static CommonClass commonclass;
	 protected static Logger log;


	@Parameters({"browserName"})
	@BeforeSuite
	public void openBrowser(@Optional("Chrome") String browserName) {
		extendreport.extentReportFilepath(FilePathsClass.extentReportFilepath);
		
		PropertyConfigurator.configure(FilePathsClass.Log4jFilepath);

		log = Logger.getLogger(DriverEngine.class);
			
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", FilePathsClass.chromedriverpath);
			driver= new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "");
			driver= new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "");
			driver= new InternetExplorerDriver();	
		}
		else
		{
	System.out.println("Browser not oprned");
		}	
		driver.manage().window().maximize();
		 commonclass = new CommonClass();
	}
	
	
	  @AfterSuite 
	  public void closeBrowser() { 
		  extendreport.closeExtentTest();
		  driver.close(); 
		  driver.quit();
		
		
	 System.out.println("Browser closed"); 
	 }
	 
	
	@BeforeMethod
	public void printMathodName(Method m) {
		
		System.out.println("Method name is "+m.getName());
		
		
	}
	
	@AfterMethod
	public void AfterMethod(ITestResult result) throws IOException {
		
		}
	
	/*
	 * @AfterClass public static void AfterClass() {
	 * r.extentTestClass("RunnerClass"); }
	 */

	
	/*
	 * @BeforeClass public static void BeforeClass(Method m) {
	 * 
	 * r.extentTestClass("RunnerClass"); }
	 */
	 

	
	}
	

