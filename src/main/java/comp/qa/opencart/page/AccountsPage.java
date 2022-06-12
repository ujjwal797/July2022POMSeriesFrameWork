package comp.qa.opencart.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
private WebDriver driver;
	
	By header= By.xpath("//h1/a[text()= 'Your Store']");
	By accountSectionHeaders = By.xpath("//div[@id='content']/h2");

	public AccountsPage(WebDriver driver) {
		this.driver= driver;
	}

	public String getAccountPageTitle() {
		return driver.getTitle();
	}
	
	public String getHeaderValue() {
	if( driver.findElement(header).isDisplayed()) {
	return driver.findElement(header).getText();
	} 
	return null;
	}
	

	public int getAccountSectionsCount() {
		return driver.findElements(accountSectionHeaders).size();
	}
	

	public List<String> getAccountSectionsList() {
		List<String> accountsList = new ArrayList<>();
		List <WebElement> accSectionList= driver.findElements(accountSectionHeaders);
		
		for(WebElement e: accSectionList) {
			String section = e.getText();
			System.out.println(section);
			
			accountsList.add(section);
		}
	return accountsList;

		
	}
}
