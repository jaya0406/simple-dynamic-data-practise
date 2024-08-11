package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
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
	public void LaunchBrowser() throws IOException 
	{
		Openbrowser();
	}

	@BeforeTest
	public void getpopup() throws Exception
	{

		String URL = PropertyFileRead.propertyread().getProperty("url").toString();
		driver.get(URL);
		
		FlightSearchPage fsp = new FlightSearchPage(driver);
		fsp.ClosePopUp();	
	}
	
	
	@Test(priority=0,dataProvider="GetValiddatas",dataProviderClass=GetDataProvider.class)
	public void FlightSearchwithDynamicValues
	(String From, String To , String Date , String Monthyr ,String adultCount,String childCount, String infantCount, String Classtype) throws Exception
	{
		test=extents.createTest("Valid Value FlightSearch - One Way");

		FlightSearchPage fsp = new FlightSearchPage(driver);
		fsp.clickfrom();
		fsp.GetFromlocation(From);
		test.log(Status.INFO, "Select From Location");
		
		fsp.clickto();
		fsp.GetToLocation(To);
		test.log(Status.INFO, "Select To Location");
		
		fsp.selectDepartureDate(Date, Monthyr);
		test.log(Status.INFO, "Select Depature Date");
		
		
		fsp.clicktravelsandclass();
		fsp.GetAdultcount(adultCount);
		fsp.GetChildcount(childCount);
		fsp.getInfantcount(infantCount);
		
		fsp.SelectTravelClass(Classtype);
		fsp.TravellersAndClassApply();
		test.log(Status.INFO, "Select Travellers and Class");
		
		fsp.SelectFareType("Regular");
		test.log(Status.INFO, "Select Fare Type");
		
		fsp.ClickSearch();
		test.log(Status.INFO, "Click Search");
		
		SearchresultPage srp = new SearchresultPage(driver);
		Assert.assertEquals(ValidValuesExcpectedResult, srp.getResult());//Comparing result
		
		String Filepath = Elements.GetScreenshot(driver, "FlightSearch_" + From + "_" + To + "_" + Date);
        test.log(Status.INFO, test.addScreenCaptureFromPath(Filepath).toString());
        
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
			else
				if(result.getStatus()==ITestResult.SKIP)
			{
				String Filepath = Elements.GetScreenshot(driver, result.getName());
				test.log(Status.INFO,test.addScreenCaptureFromPath(Filepath).toString());
				test.log(Status.SKIP,"Test Method SKIP: "+result.getName()+"is SKIPED");
			}
		
	}
	
	@AfterSuite
	public void Teardown() throws InterruptedException
	{
		CloseBrowser();
	}
}
