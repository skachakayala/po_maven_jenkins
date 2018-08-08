package reusableFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReusable {
	private String filePath;
	private FileInputStream fis;
	private Properties properties;
	
	public PropertiesReusable(String path) throws IOException
	{
		this.filePath = path;
		fis = new FileInputStream(filePath);
		properties = new Properties();
		properties.load(fis);
	}
	
	public String getPropery(String propertyValue)
	{
		return properties.getProperty(propertyValue);
	}
	
	

}
