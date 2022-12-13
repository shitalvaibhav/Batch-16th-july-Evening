package neoStoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;

public class NeoStoxPasswordPage {
	@FindBy(xpath = "//input[@id='txt_accesspin']")private WebElement passwordField;
	@FindBy(xpath = "//a[@id='lnk_submitaccesspin']")private WebElement submitButton;
	public NeoStoxPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void enterPassword(WebDriver driver,String pass)
	{
		UtilityNew.wait(driver, 1000);
		passwordField.sendKeys(pass);
		Reporter.log("ENTERING  PASSWORD", true);
	}
	public void clickSubmitButton(WebDriver driver)
	{
		UtilityNew.wait(driver, 2000);
		submitButton.click();
		Reporter.log("clicking submitButton", true);
	}

}
