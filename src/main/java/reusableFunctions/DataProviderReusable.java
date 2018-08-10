package reusableFunctions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class DataProviderReusable {
	public static Object[][] readDataExcel(String filePath,String sheetName) throws InvalidFormatException, IOException
	{
		
		ExcelData edata = ObjectUtilities.getExcelDataObj(filePath);
		Sheet sheet = edata.getSheet(sheetName);
		int lastRow=sheet.getLastRowNum()+1;
		Row row = sheet.getRow(sheet.getLastRowNum());
		int lastCell=row.getLastCellNum();
		System.out.println(lastRow+" "+lastCell);
		Object[][] data = new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
			{
				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
		ExcelData.closeInputSTream();
		return data;
	}

}
