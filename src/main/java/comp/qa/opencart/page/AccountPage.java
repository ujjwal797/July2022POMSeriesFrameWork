package comp.qa.opencart.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
private WebDriver driver;
	
	By header= By.xpath("//title");
	By accountSectionHeaders = By.xpath("//ul[contains(@class, 'css-1ntok35')]/li");

	public AccountPage(WebDriver driver) {
		this.driver= driver;
	}

	public String getAccountPageTitle() {
		return driver.getTitle();
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
