package comp.qa.opencart.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import comp.qa.opencart.utils.Constants;
import comp.qa.opencart.utils.ElementUtil;

public class registrationPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
//	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
//	private By confirmpassword = By.id("input-confirm");

	private By subscribeYes = By.xpath("//label[@class='radio-inline'][position()=1]/input");
	private By subscribeNo = By.xpath("//label[@class='radio-inline'][position()=2]/input");

	private By agreeCheckbox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value = 'Continue']");
	
	private By accountSuccessMessg = By.cssSelector("#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	public registrationPage (WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public int getRandomNumber() {
		return 1000;
	}

	public boolean accountRegistration(String firstname, String lastname, 
			String email, String password, String subscribe) {

		email = "automation" + getRandomNumber() + "@gmail.com";
		
		elementUtil.doSendKeys(this.firstname, firstname);
		elementUtil.doSendKeys(this.lastname, lastname);
		elementUtil.doSendKeys(this.email, email);//tom9898@gmail.com
//		elementUtil.doSendKeys(this.telephone, telephone);
		elementUtil.doSendKeys(this.password, password);
//		elementUtil.doSendKeys(this.confirmpassword, password);

		if (subscribe.equals("yes")) {
			elementUtil.doClick(subscribeYes);
		} else {
			elementUtil.doClick(subscribeNo);
		}

		elementUtil.doClick(agreeCheckbox);
		elementUtil.doClick(continueButton);
		
		String text = elementUtil.doGetText(accountSuccessMessg);
		if(text.contains("Account")) {
			elementUtil.doClick(logoutLink);
			elementUtil.doClick(registerLink);

			return true;
		}
		return false;
	
	}
	
}
