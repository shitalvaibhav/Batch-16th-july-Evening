package neoStoxBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;

public class Base {
	protected WebDriver driver;
	public void launchBrowser() throws IOException, InterruptedException
	{
	
		System.setProperty("webdriver.chrome.driver", "F:\\Chrome\\chromedriver.exe");
		
		 driver=new ChromeDriver();
		  
		  driver.manage().window().maximize();
		  
		 // driver.get(UtilityNew.readDataFromPropertyFile("url"));
		  driver.get("https://neostox.com/");
		  
		  
		  
		  
		  
		  
		  Reporter.log("launching browser", true);
		  Thread.sleep(1000);

	}

}
