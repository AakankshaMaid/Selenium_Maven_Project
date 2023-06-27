package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class PBUtilityClass 
{
	//Author-Aakanksha 
	//using this method you can add excel sheet test data in script
	public static String Excel(int a,int b) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\aakan\\OneDrive\\Desktop\\Maven_Selenium_Framework\\TestData\\New Microsoft Excel Worksheet.xlsx");
		String data=WorkbookFactory.create(file).getSheet("DDF").getRow(a).getCell(b).getStringCellValue();
		return data;
	}
	//this method is use to capture Failed Tc SS
	public static void captureSS(WebDriver driver,int TCID) throws IOException
	{
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\aakan\\OneDrive\\Desktop\\Maven_Selenium_Framework\\FailedTCScreenshot\\takesSS"+TCID+".jpg");
		FileHandler.copy(scr, dest);
	}
	
	//this method is use to get data from property file
	public static String getPFdata(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\aakan\\OneDrive\\Desktop\\Maven_Selenium_Framework\\PropertyFile.properties");
		Properties p=new Properties();
		p.load(file);
	String value=p.getProperty(key);
	return value;
		
		
	}
	

}
