package neoStoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityNew {
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		//create object pf properties class---->java
		Properties prop=new Properties();
		//create object of fileinputstream and pass properties file path
		FileInputStream myFile=new FileInputStream ("C:\\Users\\SAI\\eclipse-workspace\\16JUL_A_EVEN\\NsoStox.properties");
			prop.load(myFile);
			String value = prop.getProperty(key);
			Reporter.log("Reading" +key+"from property file",true);
			//System.out.println(value);
			return value;
	}
	//SCREENSHOT
	public static void screenshot(WebDriver driver, String screenShotName) throws IOException
	{
		wait(driver,500);
	File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest=new File("‪F:\\Screenshot" +screenShotName +".png");
	FileHandler.copy(scr, dest);
	Reporter.log("TAKING SCREENSHOT",true);
	}
	//SCROLLING
	public static void scrollInView(WebDriver driver,WebElement element) {
		wait(driver,500);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0],scrollInView(true)",element);
		Reporter.log("scrolling into view", true);
	}
	//wait
	public static void wait(WebDriver driver,int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		Reporter.log("WATING FOR"+waitTime+"ms",true);
	}
	
}
	

