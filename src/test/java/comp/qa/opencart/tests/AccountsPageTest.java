package comp.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import comp.qa.opencart.base.BaseTest;
import comp.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest {

//Specific to accountpage beforeclass	
	@BeforeClass
	public void accountPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void accountspageTitleTest() {
		String title= accountPage.getAccountPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "My Account"); //thses values are constant value (Constants.ACCOUNT_PAGE_TITLE)
	}
	
	@Test(priority=2)
	public void verifyPageHeaderTest() {
		String header= accountPage.getHeaderValue();
		System.out.println(header);
		Assert.assertEquals(header,Constants.ACCOUNT_PAGE_HEADER );  //Constant value
	}
	
	
	@Test(priority=4)
	public void count() {
	Assert.assertTrue(accountPage.getAccountSectionsCount()== 4);
	System.out.println(accountPage.getAccountSectionsCount());
	}
	
	@Test(priority=3)
	public void SectionList() {
	List<String> accSectionList=accountPage.getAccountSectionsList();
	System.out.println(accSectionList);
}
	
}
