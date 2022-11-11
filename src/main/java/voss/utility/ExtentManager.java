package voss.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import voss.actiondriver.Action;

/**
 * ExtentManager class is used for Extent Report
 */
public class ExtentManager {
	//Look & Feel of the report
	public static ExtentHtmlReporter htmlReporter;
	//ADD Test Cases In Report
	public static ExtentReports extent;
	//update the status of Test// Fail r Pass 
	public static ExtentTest test;
	
	public static void setExtent() {
		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+Action.getCurrentTime()+".html");
		//htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "Voss");
		extent.setSystemInfo("Tester", "Sagi");
		extent.setSystemInfo("OS", "Win11");
		extent.setSystemInfo("Browser", "Chrome");
	}
	public static void endReport() {
		extent.flush();
	}
}
