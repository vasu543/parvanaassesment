package voss.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import voss.actiondriver.Action;
import voss.base.BaseClass;

public class FakePricingPage extends BaseClass {
	Action action= new Action();
	
	@FindBy(xpath="//*[@id=\"post-5050\"]/div/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div[4]/a")
	private WebElement name1;
	
	public FakePricingPage() {
		PageFactory.initElements(getDriver(), this);
	}
		
		public void ClickBuy() {
			action.JSClick(getDriver(), name1);
		}
	}

