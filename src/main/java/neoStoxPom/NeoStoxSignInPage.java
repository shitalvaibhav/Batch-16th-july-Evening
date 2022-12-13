package neoStoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;

public class NeoStoxSignInPage {
	 @FindBy(xpath = "(//a[text()='Sign In'])[1]")private WebElement signINButton;
	 public NeoStoxSignInPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	 public void clickOnSignInButton(WebDriver driver)
	 {
		 UtilityNew.wait(driver, 6000);
		 Reporter.log("CLICKING ON Sign In button", true);
		 signINButton.click(); 
		
	
		
	 }

}
