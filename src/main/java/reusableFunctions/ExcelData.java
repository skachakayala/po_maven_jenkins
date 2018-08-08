package reusableFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {
	private static String filePath;
	Workbook workbook;
	Sheet sheet;
	private static FileInputStream fis;
	public ExcelData(String excelPath) throws InvalidFormatException, IOException
	{
		this.filePath = excelPath;
		fis = new FileInputStream(excelPath);
		workbook = WorkbookFactory.create(fis);
		
	}
	
	public Sheet getSheet(String sheetName)
	{
		sheet = workbook.getSheet(sheetName);
		return sheet ;
		
	}
	
	public int getLastrowNumber()
	{
		int lastRowNum = sheet.getLastRowNum()+1;
		return lastRowNum;
	}
	
	public static void closeInputSTream() throws IOException
	{
		if(fis!=null)
		{
			fis.close();
		}
	}
	
	

}
