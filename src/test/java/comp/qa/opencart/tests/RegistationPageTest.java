package comp.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import comp.qa.opencart.factory.DriverFactory;
import comp.qa.opencart.page.registrationPage;
import comp.qa.opencart.utils.ExcelUtil;

public class RegistationPageTest {
	
	WebDriver driver;
	public registrationPage registerPage;
	DriverFactory df;
	public Properties prop;
	
	@BeforeClass
	public void intializeRegisterPage() {
		df= new DriverFactory();
		prop = df.init_prop();		
		
		driver= df.init_Driver(prop);
		
		driver.get(prop.getProperty("RegistrationUrl"));
		registerPage = new registrationPage(driver);
	}
	

	
	
	
	
}
