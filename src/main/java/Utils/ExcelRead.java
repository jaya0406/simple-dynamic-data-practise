package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	
	protected static String excelFilepath =System.getProperty("user.dir")+"\\Input\\Dynamic data.xlsx";
	static Object value[][];
	public static Object[][] ReadExcel(String sheetname) throws IOException
	{

		File f = new File(excelFilepath);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wbk = new XSSFWorkbook(fis);
		
		Sheet sheet = wbk.getSheet(sheetname);
		int rowcount = sheet.getPhysicalNumberOfRows();
		Row  firstrow = sheet.getRow(1);
		int Totalcolumn = firstrow.getLastCellNum();
		
		value = new String[rowcount][Totalcolumn];
		
		for(int i=0; i<rowcount; i++)
		{
			Row row = sheet.getRow(i);
			int Columncount = firstrow.getLastCellNum();
			for(int j=0; j<Columncount; j++)
			{
				Cell cell = row.getCell(j);
				value[i][j]=getData(cell);
				//System.out.println(value);
			}
		}
		fis.close();
		return value;
		
	}
	
	public static Object getData(Cell cellvalue)
	{
		if(cellvalue.getCellType().toString()=="STRING")
		{
			return cellvalue.getStringCellValue();
		}
		else
		{
			DataFormatter df = new DataFormatter();
			return df.formatCellValue(cellvalue);
		}
	}

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		ExcelRead er = new ExcelRead();
		//er.ReadExcel("Validdata");
	}

}
