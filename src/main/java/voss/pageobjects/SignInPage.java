package voss.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import voss.actiondriver.Action;
import voss.base.BaseClass;

public class SignInPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "/html/body/header/div/div/section[1]/ul/li/a/i")
	private WebElement AccountDropDownOptions;

	@FindBy(className = "dropdown__menu-item")
	private List<WebElement> list1;

	public SignInPage() {

		PageFactory.initElements(getDriver(), this);
	}

	public void SignOut() {
		action.JSClick(getDriver(), AccountDropDownOptions);
		for (WebElement ele : list1) {
			String value = ele.getText();
			System.out.println(value);
			if (value.equalsIgnoreCase("Sign Out")) {
				ele.click();
				break;
			}
		}
	}
}
