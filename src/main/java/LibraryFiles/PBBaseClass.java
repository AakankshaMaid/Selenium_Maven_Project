package LibraryFiles;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class PBBaseClass
{
	public WebDriver driver;
	
	public void initializeBrowser(String browserName) throws IOException
	{
		if(browserName.equals("chrome"))
		{
		driver=new ChromeDriver();
		}
		if(browserName.equals("edge"))
		{
		driver=new EdgeDriver();
		}
		
		//driver.manage().window().maximize();
		driver.navigate().to(PBUtilityClass.getPFdata("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	

}
