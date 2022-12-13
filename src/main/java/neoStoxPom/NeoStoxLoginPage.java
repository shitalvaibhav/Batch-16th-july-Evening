package neoStoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;

public class NeoStoxLoginPage {
	//declaration
	@FindBy(xpath = "//input[@id='MainContent_signinsignup_txt_mobilenumber']")private WebElement mobileNumField;
	@FindBy(xpath = "(//a[text()='Sign Up'])[2]")private WebElement signInButton;


//initialization
public NeoStoxLoginPage (WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void sendMobileNum(WebDriver driver,String mobNum)
{
	UtilityNew.wait(driver,1000);
	mobileNumField.sendKeys(mobNum);
	Reporter.log("ENTERRING MOBILRNO", true);
}
public void clickOnSignInButton(WebDriver driver)
{
	UtilityNew.wait(driver, 6000);
	signInButton.click();
	Reporter.log("CLICKING SIGNINBUTTON",true);
}
}
