package com.capium.automation.pogoClass;

public class FilePathsClass {
	
	public static String extentReportFilepath = "C:\\Users\\bigbrother\\Documents\\Automation\\capium\\capium\\ExtentLogs\\RunnerClass.html";
	public static String config_prFilepath = "C:\\Users\\bigbrother\\Documents\\Automation\\capium\\capium\\src\\test\\resources\\cofig.properties";
	public static String Log4jFilepath = "C:\\Users\\bigbrother\\Documents\\Automation\\capium\\capium\\src\\test\\resources\\Log4j.properties";
	public static String chromedriverpath = "C:\\Users\\bigbrother\\Documents\\Automation\\capium\\capium\\src\\test\\resources\\Drivers\\chromedriver.exe";
	public static String excelFilepath = "C:\\Users\\bigbrother\\Documents\\Automation\\capium\\capium\\src\\test\\resources\\CreateClientDetails.xlsx";
	
	public static String getExtentReportFilepath() {
		return extentReportFilepath;
	}

	public static String getchromedriverFilepath() {
		return chromedriverpath;
	}
	
	public static String getLog4jFilepath() {
		return Log4jFilepath;
	}
	
	public static String getconfig_prFilepath() {
		return config_prFilepath;
	}
	
	public static String getExcelFilepath() {
		return excelFilepath;
	}
	
}
