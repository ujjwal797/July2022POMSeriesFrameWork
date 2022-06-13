package comp.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import comp.qa.opencart.base.BaseTest;
import comp.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest {

//Specific to accountpage before class	
	@BeforeClass
	public void accountPageSetup() {
		accountPage =loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void getTitle() {
		String title= accountPage.getAccountPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	public void listSize() {
		int size =accountPage.getAccountSectionsSizeCount();
		System.out.println(size);
		Assert.assertTrue(size>0);
	}
	
	
	public void SectionList() {
		List<String> list= accountPage.getAccountSectionsList();
		System.out.println(list);
//		Assert.assertEquals(0, 0);
	}
}
	
