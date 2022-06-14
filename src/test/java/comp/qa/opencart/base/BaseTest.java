package comp.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import comp.qa.opencart.factory.DriverFactory;
import comp.qa.opencart.page.AccountPage;
import comp.qa.opencart.page.AccountPageAsGuestUser;
import comp.qa.opencart.page.LoginPage;

public class BaseTest {
	
//	create reference and import because its coming from different package
	DriverFactory df; 
	public Properties prop; // using in other methods
	WebDriver driver;
	
//	Reference for loginPage class for LoginPageTest class also declaring here in parent class
	public LoginPage loginPage; // public to access in login
	public AccountPage accountPage;
	public AccountPageAsGuestUser guestUser;
	
	@BeforeTest
	public void setup() {
	
//		selected first because first we have to see which browser is written(chrome).		
		df = new DriverFactory();
		prop = df.init_prop();		
//		String browserName = prop.getProperty("browser"); now this is done by driver factory.
		driver= df.init_Driver(prop);
	
//		driver.get(prop.getProperty("url"));
		driver.get(prop.getProperty("GuestUrl"));
		
//		This driver will call the constructor and constructor than pass to LoginPage class driver			
		loginPage = new LoginPage(driver); 
		guestUser = new AccountPageAsGuestUser(driver);
	}  
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
