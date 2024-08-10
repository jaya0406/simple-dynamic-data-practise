package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Driver_Browser.Driver;
import ElementUtils.Elements;
import Pages.FlightSearchPage;
import Pages.SearchresultPage;
import Utils.PropertyFileRead;

public class FunctionalityTesting_Flights extends Driver
{
	
	public String ValidValuesExcpectedResult ="NETWORK PROBLEM";
	
	@BeforeSuite
	public void LaunchBrowser() throws Exception
	{
		Openbrowser();
		
		String URL = PropertyFileRead.propertyread().getProperty("url").toString();
		driver.get(URL);
	}

	
	
	@Test(priority=0,dataProvider="GetValiddatas",dataProviderClass=GetDataProvider.class)
	public void ValidValueFlightSearch(String From, String To , String Date , String Monthyr, String Faretype) throws Exception
	{
		test=extents.createTest("Valid Value FlightSearch - One Way");

		FlightSearchPage fsp = new FlightSearchPage(driver);
		
		fsp.clickfrom();
		fsp.GetFromlocation(From);
		test.log(Status.INFO, "Select From Location");
		
		fsp.clickto();
		fsp.GetToLocation(To);
		test.log(Status.INFO, "Select To Location");
		
		fsp.SelectDepaturedate(Date, Monthyr);
		test.log(Status.INFO, "Select Depature Date");
		
		fsp.getTravellers(2, 3, 2, 1, 1);//Adult count, Child Age, Child count, Infant Age, Infant count
		fsp.SelectTravelClass(Faretype);
		fsp.TravellersAndClassApply();
		test.log(Status.INFO, "Select Travellers and Class");
		
		fsp.SelectFareType("Regular");
		test.log(Status.INFO, "Select Fare Type");
		
		fsp.ClickSearch();
		test.log(Status.INFO, "Click Search");
		
		SearchresultPage srp = new SearchresultPage(driver);
		Assert.assertEquals(ValidValuesExcpectedResult, srp.getResult());//Comparing result
		driverBackButton();
	}
	
	@AfterMethod
	public void AddScreenshotInReport(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			String Filepath = Elements.GetScreenshot(driver, result.getName());
			test.log(Status.INFO,test.addScreenCaptureFromPath(Filepath).toString());
			test.log(Status.PASS,"Test Method PASS: "+result.getName()+"is PASSED");
		}
		else 
			if(result.getStatus()==ITestResult.FAILURE)
			{
				String Filepath = Elements.GetScreenshot(driver, result.getName());
				test.log(Status.INFO,test.addScreenCaptureFromPath(Filepath).toString());
				test.log(Status.FAIL,"Test Method FAIL: "+result.getName()+"is FAILED");
				test.log(Status.FAIL,"Test failure : "+ result.getThrowable());
			}
			else if(result.getStatus()==ITestResult.SKIP)
			{
				String Filepath = Elements.GetScreenshot(driver, result.getName());
				test.log(Status.INFO,test.addScreenCaptureFromPath(Filepath).toString());
				test.log(Status.SKIP,"Test Method SKIP: "+result.getName()+"is SKIPED");
			}
		
	}
	
	@AfterSuite
	public void Teardown()
	{
		CloseBrowser();
	}
}
