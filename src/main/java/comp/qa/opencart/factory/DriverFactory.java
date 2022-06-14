package comp.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

//	WebDriver driver;		//after introducing Thread-local driver is not used.
	Properties prop;
//	public static String highlight;   //not using
//	OptionsManager optionManger;	  //not using
	
	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<>();
	
	
	public WebDriver init_Driver(Properties prop) {
//	public WebDriver init_Driver(String BrowserName) {
	
		String BrowserName= prop.getProperty("browser");
//		highlight = prop.getProperty("highlight"); 	//not using
//		optionManger= new OptionsManager(prop); 	//not using
		
		
		if (BrowserName.equals("Safari")) {
//			driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		}	
		else if (BrowserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver(); // not using
//			driver = new ChromeDriver(optionManger.getChromeOptions());   //option class used
//			tlDriver.set(new ChromeDriver(optionManger.getChromeOptions()));//option class+ thread local
		}
		
		else {
			System.out.println("pass the right browser");
		}
		getTlDriver().manage().deleteAllCookies();
		getTlDriver().manage().window().maximize();
		
		return getTlDriver();
	}
	
//	Static because can call without creating obj
	public static synchronized WebDriver getTlDriver(){
		return tlDriver.get();
	}

	public Properties init_prop() { //these are our environment variable
	prop =new Properties(); //properties responsible to read values from config.properties
		  
		 try {
//			for any file interaction like prop file we create file input stream
			FileInputStream ip= new FileInputStream("./src/test/resources/config/config.properties"); 
			prop.load(ip);
		 	 }
		 			catch (FileNotFoundException e) {
		 					e.printStackTrace();
		 			} catch (IOException e) 		{
		 		  			e.printStackTrace();
		 			}
		
		 return prop;
	}

	
	
	
//	public String getScreenshot() {
//		String src = ((TakesScreenshot) init_Driver(prop)).getScreenshotAs(OutputType.BASE64);
//		File srcFile = new File(src);
//		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
//		File destination = new File(path);
//		try {
//			FileUtils.copyFile(srcFile, destination);
//		} catch (IOException e) {
////			LOGGER.error("some exception is coming while creating the screenshot");
//			e.printStackTrace();
//		}
//		return path;
//	}
	
	
}
