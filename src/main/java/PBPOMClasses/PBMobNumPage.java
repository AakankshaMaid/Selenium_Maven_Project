package PBPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBMobNumPage
{
	@FindBy(xpath="(//input[@id='central-login-module-sign-mobile'])[2]")private WebElement mobNum;
	@FindBy(xpath="(//span[text()='Sign in with Password'])[2]")private WebElement SignInWithPwd;
	
	public PBMobNumPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void inputPBMobNumPagemobNum(String mob)
	{
		mobNum.sendKeys(mob);
	}
	public void clickPBMobNumPageSignInWithPwd()
	{
		SignInWithPwd.click();
	}
	

}
