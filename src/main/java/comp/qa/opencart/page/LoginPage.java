package comp.qa.opencart.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

//1.In every page class remember we need to maintain by-locators/Object repository
	
	private WebDriver driver;
	
	private By username = By.id("username");
	private By Password = By.id("password");
	private By loginButton	= By.xpath("//button[contains(text(), 'Sign in')]");
	
	private By forgotpwd = By.xpath("//a[contains(@href, 'forgot-password')]");
	
	
//2. Constructor of the class
	public LoginPage (WebDriver driver) {
		this.driver = driver;
	}
	
//3. Page Method/action (title)
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
//3. 	Link available
		public Boolean isforgotPwdlinkExist() {
			return driver.findElement(forgotpwd).isDisplayed();
		}
//4.	Login
		public AccountPage doLogin(String un, String pwd) {
			driver.findElement(username).sendKeys(un);
			driver.findElement(Password).sendKeys(pwd);
			driver.findElement(loginButton).click();
		
//	This return is responsible to go the the next page,	
			return new AccountPage(driver);	
		}
	
}
