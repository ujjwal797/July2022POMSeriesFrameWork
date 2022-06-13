package comp.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import comp.qa.opencart.base.BaseTest;
import comp.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest {

	
	@Test
	public void loginPageTitleTest() {
		String title= loginPage.getLoginPageTitle();
		System.out.println(title);	//cx should not have driver API			
		Assert.assertEquals(title, "Walmart Canada"); 
	}
	
	@Test
	public void forgotPwdlinkExist() {
		Assert.assertTrue(loginPage.isforgotPwdlinkExist());
	}
	
	@Test
	public void loginTest() throws InterruptedException {
	loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
//	Its a incomplete method because assertion is missing, so we are asserting to check whthr its going to nxt page.
//	Assert.assertEquals(accountPage.getAccountPageTitle(), Constants.ACCOUNT_PAGE_TITLE);
	}
}
