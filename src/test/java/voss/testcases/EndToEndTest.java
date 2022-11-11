/**
 * 
 */
package voss.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import voss.base.BaseClass;
import voss.pageobjects.FakePricingPage;
import voss.pageobjects.FillOutForms;
import voss.pageobjects.HomePage;
import voss.pageobjects.LoginAutomationPage;
import voss.pageobjects.SignInPage;
import voss.utility.Log;
import voss.utility.MyScreenRecorder;

public class EndToEndTest extends BaseClass {
	private HomePage homePage;
	private LoginAutomationPage loginAutomationPage;
	private SignInPage signInPage;
	private FillOutForms fillOutForms;
	private FakePricingPage fakePricingPage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

	@Test(priority = 1)
	public void validateTitle() throws Throwable {
		Log.startTestCase("validateTitle");
		//Log.info("validateTitle");
		MyScreenRecorder.startRecording("validateTitle");
		homePage = new HomePage();
		String ActualTitle = homePage.gettitle();
		Assert.assertTrue(ActualTitle.contains("Automation Practice - Ultimate QA12345"));
		MyScreenRecorder.stopRecording();
		Log.endTestCase("validateTitle");
	}

	@Test(priority = 2)
	public void ScreensotOfPage() throws Exception {
		MyScreenRecorder.startRecording("ScreensotOfPage");
		homePage = new HomePage();
		homePage.homepagescreenshot();
		MyScreenRecorder.stopRecording();
	}

	@Test(priority = 3)
	public void LogInAndSignOut() throws Throwable {
		MyScreenRecorder.startRecording("LogInAndSignOut");
		homePage = new HomePage();
		loginAutomationPage = homePage.clickOnLoginAutomation();
		signInPage = loginAutomationPage.login();
		signInPage.SignOut();
		MyScreenRecorder.stopRecording();
	}

	@Test(priority = 4)
	public void FillOutFormsSignInOut() throws Exception {
		MyScreenRecorder.startRecording("FillOutFormsSignInOut");
		homePage = new HomePage();
		fillOutForms = homePage.clickOnFillOutForms();
		fillOutForms.fillingDetails();
		MyScreenRecorder.stopRecording();
	}

	@Test(priority = 5)
	public void FakePricingPageTest() throws Throwable {
		MyScreenRecorder.startRecording("FakePricingPageTest");
		homePage = new HomePage();
		fakePricingPage = homePage.clickOnFakePricingPage();
		fakePricingPage.ClickBuy();
		MyScreenRecorder.stopRecording();
	}
}
