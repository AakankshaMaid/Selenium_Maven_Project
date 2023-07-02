package PBPOMClasses;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBMyAccPage 
{
	@FindBy(xpath="//span[text()=' My profile ']")private WebElement profile;
	
   
	public PBMyAccPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public void clickPBMyAccPageprofile()
	{
		profile.click();
	}
	
////a[@class='ico-2']

}
////i[@class='menu-icon-bg urpolicy']