package reusableFunctions;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import reusableFunctions.PropertiesReusable;

public class ObjectUtilities {
	

	private static String configFilepath = System.getProperty("user.dir")+"\\Utilities\\LoginConfigs.properties";
	
	private static String exelFilePath = System.getProperty("user.dir")+"\\TestData\\LoginData2.xlsx";
	
	private static PropertiesReusable propertiesReusables;
	
	private static ExcelData excelDataObj;
	
	public static PropertiesReusable getPropertiesObject(String filePath) throws IOException
	{
		propertiesReusables = new PropertiesReusable(filePath);
		return propertiesReusables;
	}
	
	public static String getConfigFilepath()
	{
		return configFilepath;
	}
	
	public static ExcelData getExcelDataObj(String path) throws InvalidFormatException, IOException
	{
		return new ExcelData(path);
	}
	
	public static String getExcelFilePath()
	{
		return exelFilePath;
	}
}
