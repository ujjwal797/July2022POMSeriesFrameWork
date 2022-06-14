package comp.qa.opencart.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import comp.qa.opencart.utils.Constants;
import comp.qa.opencart.utils.ElementUtil;

public class AccountPageAsGuestUser {
private WebDriver driver;
private ElementUtil elementUtil;
	
	By header= By.xpath("//title");
	By accountSectionHeaders = By.xpath("//ul[contains(@class, 'css-1ntok35')]/li");

	public AccountPageAsGuestUser(WebDriver driver) {
		this.driver= driver;
		elementUtil= new ElementUtil(this.driver=driver); //to use util class
	}

	public String getAccountPageTitle() {
		return elementUtil.waitForPageTitlePresent(Constants.ACCOUNT_PAGE_TITLE, 5);
	}

	public int getAccountSectionsSizeCount() {
		int size= driver.findElements(accountSectionHeaders).size();
		return size;
	}
	
	
	public List<String> getAccountSectionsList() {
		List<String> headerList= new ArrayList<String>();
		List<WebElement> list= driver.findElements(accountSectionHeaders);
		for(WebElement e: list) {
			System.out.println(e.getText());
			
			headerList.add(e.getText());
		}
		return headerList;
	}
}
