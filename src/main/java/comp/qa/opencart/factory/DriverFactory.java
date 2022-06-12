package comp.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	WebDriver driver;
	Properties prop;
	public static String highlight;
	
	/**
	 * 
	 * @param Browser
	 * @return
	 */
	
	public WebDriver init_Driver(Properties prop) {
	
		String Browser= prop.getProperty("browser");
		highlight = prop.getProperty("highlight");
		
		if (Browser.equals("Safari")) {
			driver = new SafariDriver();
		}
		
		else if (Browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else {
			System.out.println("pass the right browser");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		return driver;

	}
	
	/**
	 * 
	 * @return
	 */

	public Properties init_prop1() { //these are our environment variable
	prop =new Properties(); //responsible to read values from config.properties
		 
		 
		 try {
//			 for any file interaction like prop file we create file input stream
			FileInputStream ip= new FileInputStream("./src/test/resources/config/config.properties");//	For  file interaction 
			prop.load(ip);
		 	 }
		 			catch (FileNotFoundException e) {
		 					e.printStackTrace();
		 			} catch (IOException e) 		{
		 		  			e.printStackTrace();
		 			}
		
		 return prop;
	}

	/**
	 * take sceenshot Ashot
	 */
	public String getScreenshot() {
		String src = ((TakesScreenshot) init_Driver(prop)).getScreenshotAs(OutputType.BASE64);
		File srcFile = new File(src);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
//			LOGGER.error("some exception is coming while creating the screenshot");
			e.printStackTrace();
		}
		return path;
	}
	
	
}
