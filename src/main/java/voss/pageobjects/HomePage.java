package voss.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import voss.actiondriver.Action;
import voss.base.BaseClass;

public class HomePage extends BaseClass 
{
	Action action= new Action();
	
	@FindBy(xpath="//a[contains(text(),'Fill out forms')]")
	private WebElement FillOutFormsLink;

	@FindBy(xpath="//a[contains(text(),'Login automation')]")
	private WebElement loginAutomationLink;
	
	@FindBy(xpath="//a[contains(text(),'Fake Pricing Page')]")
	private WebElement FakePricingPagelink;
		
	public HomePage() {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public String gettitle() {
		String title=action.getTitle(getDriver());
		//System.out.println(title);
		return title;
		
	}
				
	public void homepagescreenshot() {
		action.screenShot(getDriver(), "xyz");
		
	}
	
	public LoginAutomationPage clickOnLoginAutomation() {
		action.click(getDriver(), loginAutomationLink);
		return new LoginAutomationPage();
	}
	
	public FakePricingPage clickOnFakePricingPage() {
		action.click(getDriver(), FakePricingPagelink);
		return new FakePricingPage();
	}
	public FillOutForms clickOnFillOutForms() {
		action.click(getDriver(), FillOutFormsLink);
		return new FillOutForms();
	}

}
