package voss.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import voss.actiondriver.Action;
import voss.base.BaseClass;

public class FillOutForms extends BaseClass {
Action action= new Action();
	
	@FindBy(id="et_pb_contact_name_0")
	private WebElement name1;
	
	@FindBy(xpath="//*[@id=\"et_pb_contact_message_0\"]")
	private WebElement message1;
	
	@FindBy(xpath="//*[@id=\"et_pb_contact_form_0\"]/div[2]/form/div/button")
	private WebElement Submit1;
	
	@FindBy(xpath="//*[@id=\"et_pb_contact_name_1\"]")
	private WebElement name2;
	
	@FindBy(xpath="//*[@id=\"et_pb_contact_message_1\"]")
	private WebElement message2;
	
	@FindBy(className="et_pb_contact_captcha_question")
	private WebElement mathLogic;
	
	@FindBy(className="et_pb_contact_captcha")
	private WebElement value;
	
		
	@FindBy(xpath="//*[@id=\"et_pb_contact_form_1\"]/div[2]/form/div/button")
	private WebElement Submit2;

		
	public FillOutForms() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void fillingDetails() {
		action.selectBySendkeys("Andrew", name1);
		action.selectBySendkeys("First Form Filling Successfully", message1);
		action.selectBySendkeys("vernique", name2);
		action.selectBySendkeys("Second Form Filling Successfully", message2);
		String str=mathLogic.getText();
		String[] ints = str.split("\\s");
		String int1= ints[0];
		String int2 = ints[2];
		Integer val1 = Integer.valueOf(int1);
		Integer val2 = Integer.valueOf(int2);
		Integer total = val1 + val2;		
		action.selectBySendkeys(total.toString(),value);
		action.JSClick(getDriver(), Submit1);
		action.JSClick(getDriver(), Submit2);
		System.out.println("Sucessfully Submited forms");			
				
	}
}
