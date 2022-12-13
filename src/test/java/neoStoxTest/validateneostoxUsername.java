package neoStoxTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import neoStoxBase.Base;
import neoStoxPom.NeoStoxHomePage;
import neoStoxPom.NeoStoxLoginPage;
import neoStoxPom.NeoStoxPasswordPage;
import neoStoxUtility.UtilityNew;

public class validateneostoxUsername extends Base {
	NeoStoxLoginPage login;
	NeoStoxPasswordPage password;
	NeoStoxHomePage home;
	//NeoStoxSignInPage signln;
	@BeforeClass
	public void launchNeoStox() throws IOException, InterruptedException
	{
		launchBrowser();//from base class
		login=new NeoStoxLoginPage(driver);
		password=new NeoStoxPasswordPage(driver);
		home=new NeoStoxHomePage(driver);
		//signln=new NeoStoxSignInPage(driver);
	
	}
	
  @BeforeMethod
  public void loginNeoStox() throws IOException, InterruptedException {
	 // signln.clickOnSignInButton(driver);
	  //Thread.sleep(2000);
	  login.sendMobileNum(driver, UtilityNew.readDataFromPropertyFile("mobileNum"));
	  Thread.sleep(3000);
	  login.clickOnSignInButton(driver);
	  UtilityNew.wait(driver, 1000);
	  password.enterPassword(driver, UtilityNew.readDataFromPropertyFile("Password"));
	  Thread.sleep(2000);
	  password.clickSubmitButton(driver);
	  Thread.sleep(5000);
	  home.handlePopUP(driver);
	  
  }
  @Test
  public void validateUserID() throws IOException
  {
	Assert.assertEquals(home.getActualUserName(driver), UtilityNew.readDataFromPropertyFile("userName"),"TC is failed Actual and expected User Name are not matching");
		  
  }
//  @Test
 //public void validateAccBalance()
  //{
//	 Assert.assertEquals(home.getAccBalance(driver), "TC failed Unable to fetch account Balance");
	// Reporter.log("AC balance is, "+home.getAccBalance(driver),true);
  //}
  
  @AfterMethod
  public void logOutFromNeoStox()
  {
	  home.logOut(driver);
  }
  @AfterClass
  public void closeBrowser()
  {
	 Reporter.log("closing browser", true);
	  driver.close();
  }
  
}
