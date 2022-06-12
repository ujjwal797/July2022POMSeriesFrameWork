package comp.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import comp.qa.opencart.factory.DriverFactory;
import comp.qa.opencart.page.AccountsPage;
import comp.qa.opencart.page.LoginPage;

public class BaseTest {
	
//	create reference and import because its coming from different package
	DriverFactory df; 
	public	Properties prop;
	WebDriver driver;
	
//	Reference for loginPage class for LoginPageTest class also declaring here in parent class
	public LoginPage loginPage;
	
	public AccountsPage accountPage;
	
	@BeforeTest
	public void setup() {
	
	
//		selected first because first we have to see which browser is written(chrome).		
//		prop = df.init_prop1();		
//		String browsername = prop.getProperty("browser");
	
		df=new DriverFactory();
		driver= df.init_Driver(prop);
		
		driver.get(prop.getProperty("url"));
		
//		This driver will call the constructor and constructor than pass to LoginPage class driver			
		loginPage = new LoginPage(driver); 

	}  
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
