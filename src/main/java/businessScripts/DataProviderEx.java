package businessScripts;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import reusableFunctions.DataProviderReusable;
import reusableFunctions.ExcelData;
import reusableFunctions.ObjectUtilities;

public class DataProviderEx {
	
	
	
	
	@Test(dataProvider="excelData")
	public void login(String username,String password,String ssn,String dob,String beginDate)
	{
		System.out.println(username+" "+password+" "+ssn+" "+dob+" "+beginDate);
	}
	
	@DataProvider(name="excelData")
	public Object[][] getData() throws InvalidFormatException, IOException
	{
		return DataProviderReusable.readDataExcel(ObjectUtilities.getExcelFilePath(),"Sheet1");
	}

}

