package voss.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import voss.actiondriver.Action;
import voss.base.BaseClass;

public class LoginAutomationPage extends BaseClass {
	Action action = new Action();

	@FindBy(id = "user[email]")
	private WebElement userName;

	@FindBy(id = "user[password]")
	private WebElement password;

	@FindBy(className = "button-primary")
	private WebElement signInBtn;

	public LoginAutomationPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public SignInPage login() throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, prop.getProperty("username"));
		action.scrollByVisibilityOfElement(getDriver(), password);
		action.type(password, prop.getProperty("password"));
		action.JSClick(getDriver(), signInBtn);
		Thread.sleep(2000);
		return new SignInPage();

	}
}
