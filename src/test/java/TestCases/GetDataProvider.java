package TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utils.ExcelRead;

public class GetDataProvider 
{
	@DataProvider
	public Object[][] GetValiddatas() throws IOException
	{
		return ExcelRead.ReadExcel("Validdata");
	}
}
