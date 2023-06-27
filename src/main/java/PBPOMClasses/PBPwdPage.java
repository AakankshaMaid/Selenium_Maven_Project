package PBPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBPwdPage 
{
	@FindBy(xpath="//input[@id='central-login-password']")private WebElement Pwd;
	@FindBy(xpath="//span[text()='Sign in']")private WebElement sigin;
	
	public PBPwdPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void inputPBPwdPagePwd(String pw)
	{
		Pwd.sendKeys(pw);
	}
	public void clickPBPwdPagesigin()
	{
		sigin.click();
	}

}
