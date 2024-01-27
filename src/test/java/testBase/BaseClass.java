package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageObjects.HomePage;
import pageObjects.SearchResultPage;

public class BaseClass {
	
	//defining webdriver
		public static WebDriver driver;
		public static Properties fileobj;
		
		@BeforeClass
		public static void setup() throws IOException
		{
			//loading properties file
			
			driver = getDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			
			//loading url
			driver.get(fileobj.getProperty("appURL"));
			driver.manage().window().maximize();
		}
		
		public String captureScreen(String tname) throws IOException {

			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
					
			TakesScreenshot takesScreenshot = (TakesScreenshot)driver;

			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
				
			return targetFilePath;
		}

		@AfterClass
		public void tearDown()
		{
			driver.quit();
		}
		
		// get the different browser from config.properites
		public static WebDriver getDriver() throws IOException {
			FileReader file=new FileReader(".//src//test//resources//config.properties");
			fileobj=new Properties();
			fileobj.load(file);
			//driver initialization
			switch(fileobj.getProperty("browser")) {
				case "Chrome":
					return new ChromeDriver();
				case "Edge":
					return new EdgeDriver();
				case "Firefox":
					return new FirefoxDriver();
			}
			return new ChromeDriver();
		}
		
		// utilized for product search in Filterby
		public static void getProduct() throws InterruptedException {
			HomePage hp= new HomePage(driver);
			SearchResultPage sresult= new SearchResultPage(driver);
			hp.searchClick();
			Thread.sleep(500);
			hp.innersearchClick(fileobj.getProperty("productname"));
			Thread.sleep(500);
			sresult.clickAvailability();
			Thread.sleep(500);
		}
		
		

}
