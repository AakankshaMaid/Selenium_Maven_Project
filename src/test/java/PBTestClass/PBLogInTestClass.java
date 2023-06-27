package PBTestClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import LibraryFiles.PBBaseClass;
import LibraryFiles.PBUtilityClass;
import PBPOMClasses.PBHomePage;
import PBPOMClasses.PBLogInPage;
import PBPOMClasses.PBMobNumPage;
import PBPOMClasses.PBMyAccPage;
import PBPOMClasses.PBProfilePage;
import PBPOMClasses.PBPwdPage;

public class PBLogInTestClass extends PBBaseClass
{
	PBLogInPage login;PBMobNumPage mob ; PBPwdPage pwd;PBHomePage home;PBMyAccPage myacc;PBProfilePage profile;
	int TCID;
	@Parameters("browserName")
	@BeforeClass
	public void openBrowser(String browserName) throws InterruptedException, IOException
	{
		initializeBrowser(browserName);
		Thread.sleep(2000);
		login=new PBLogInPage(driver);
		mob=new PBMobNumPage(driver);
		pwd=new PBPwdPage(driver);
		home=new PBHomePage(driver);
		myacc=new PBMyAccPage(driver);
		profile=new PBProfilePage(driver);
	}
	@BeforeMethod
	public void login() throws InterruptedException, IOException
	{
		login.clickPBLogInPagesigin();
		Thread.sleep(2000);
		mob.inputPBMobNumPagemobNum(PBUtilityClass.getPFdata("MobNum"));
		Thread.sleep(2000);
		mob.clickPBMobNumPageSignInWithPwd();
		Thread.sleep(2000);
		pwd.inputPBPwdPagePwd(PBUtilityClass.getPFdata("Pwd"));
		Thread.sleep(2000);
		pwd.clickPBPwdPagesigin();
		Thread.sleep(2000);
			
	}
	@Test
	public void verify() throws InterruptedException, EncryptedDocumentException, IOException
	{
		TCID=101;
      home.openDDListPBHomePagemyacc();
      Thread.sleep(2000);
      myacc.clickPBMyAccPageprofile();
      Thread.sleep(2000);
      profile.switchtowindow();
      Thread.sleep(2000);
     String actualresult= profile.verifyPBProfilePagefullname();
     Assert.assertEquals(actualresult, PBUtilityClass.Excel(0, 2));
     Reporter.log("Verifyied by Aakanksha",true);
	}
	@AfterMethod
	public void faildTCSS(ITestResult s1) throws IOException
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			PBUtilityClass.captureSS(driver,TCID);
		}
		
	}
	@AfterClass
	public void logout() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}

}
