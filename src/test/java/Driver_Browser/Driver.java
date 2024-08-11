package Driver_Browser;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utils.PropertyFileRead;

public class Driver 
{
	public WebDriver driver;
	
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extents;
	public static ExtentTest test;
	
	
	String reportpath = System.getProperty("user.dir")+"\\Report\\Automation.html";
	public void Openbrowser() throws IOException
	{
		String getbrowser= PropertyFileRead.propertyread().getProperty("browser");
		
		if(getbrowser.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else
		{
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		generateReport();
	}
	
	public void driverBackButton() throws InterruptedException
	{
		driver.navigate().back();
		Thread.sleep(1000);
	}
	
	public void generateReport()
	{
		htmlReporter = new ExtentSparkReporter(reportpath);
		extents = new ExtentReports();
		extents.attachReporter(htmlReporter);
	}
	
	public void savereport()
	{
		extents.flush();
	}
	
	public void CloseBrowser() throws InterruptedException
	{
		
		savereport();
		driver.close();
	}
}
