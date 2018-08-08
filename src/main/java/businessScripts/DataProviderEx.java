package businessScripts;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import reusableFunctions.ExcelData;
import reusableFunctions.ObjectUtilities;

public class DataProviderEx {
	
	
	
	@DataProvider(name="excelData")
	public Object[][] readDataExcel() throws InvalidFormatException, IOException
	{
		System.out.println(ObjectUtilities.getExcelFilePath());
		ExcelData edata = ObjectUtilities.getExcelDataObj(ObjectUtilities.getExcelFilePath());
		Sheet sheet = edata.getSheet("Sheet1");
		int lastRow=sheet.getLastRowNum();
		Row row = sheet.getRow(sheet.getLastRowNum());
		int lastCell=row.getLastCellNum();
		System.out.println(lastRow+" "+lastCell);
		Object[][] data = new Object[lastRow][lastCell];
		for(int i=0;i<lastRow-1;i++)
		{
			for(int j=0;j<sheet.getRow(i).getLastCellNum()-1;j++)
			{
				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
		ExcelData.closeInputSTream();
		return data;
	}
	
	@Test(dataProvider="excelData")
	public void login(String username,String password,String ssn,String dob,String beginDate)
	{
		System.out.println(username+" "+password+" "+ssn+" "+dob+" "+beginDate);
	}

}

