package comp.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import comp.qa.opencart.base.BaseTest;
import comp.qa.opencart.utils.Constants;

public class AccountPageAsGuestUserTest extends BaseTest{
	
	
	@Test
	public void getTitle() {
		String title= guestUser.getAccountPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	@Test
	public void listSize()  {
		int size =guestUser.getAccountSectionsSizeCount();
		System.out.println(size);
		Assert.assertTrue(size==7);
	}
	
	@Test
	public void SectionList() {
		List<String> list= guestUser.getAccountSectionsList();
		System.out.println(list);
//		Assert.assertEquals(0, 0);
	}
}
