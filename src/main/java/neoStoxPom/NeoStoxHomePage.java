package neoStoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;

public class NeoStoxHomePage {
	@FindBy(xpath = "(//a[text()='OK'])[2]")private WebElement okButton;
	@FindBy(xpath = "(//a[text()='Close'])[5]")private WebElement closeButton;
	@FindBy(xpath = "//span[@id='lbl_username']")private WebElement userName;
	@FindBy(xpath = "//span[@id='lbl_curbalancetop']")private WebElement acBalance;
	@FindBy(xpath = "//span[text()='Logout']")private WebElement logOutButton;
	
	public NeoStoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this );
	}
	public void handlePopUP(WebDriver driver) throws InterruptedException
	{
		if(okButton.isDisplayed())
		{
		UtilityNew.wait(driver, 9000);
		 okButton.click();
		 Reporter.log("handeling popup", true);
		 Reporter.log("CLICKING ON OK BUTTON OF POPUP",true);
		 UtilityNew.wait(driver, 12000);
		 closeButton.click();
		 Reporter.log("CLICKING ON CLOSE BUTTON OF POPUP",true);
	}
		else
		{
			Reporter.log("there is no popup", true);
			Thread.sleep(3000);
		}
		
	}
	public String getActualUserName(WebDriver driver)
	{
		UtilityNew.wait(driver, 3000);
		String actualUserName=userName.getText();
		Reporter.log("getting actual user name", true);
		String realUserName=actualUserName.substring(3);
		Reporter.log("Actual user name is" +realUserName, true);
		return actualUserName;
	}
	public String getAccBalance(WebDriver driver)
	{
		UtilityNew.wait(driver, 3000);
		String accBalance=acBalance.getText();
		Reporter.log("getting accBalance", true);
		Reporter.log("Account Balance is "+accBalance ,true);
		return accBalance;
	}
	public void logOut(WebDriver driver)
	{
		UtilityNew.wait(driver, 3000);
		userName.click();
		UtilityNew.wait(driver, 3000);
		logOutButton.click();
		Reporter.log("logging out", true);
	}
		
		
	}


