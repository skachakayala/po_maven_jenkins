package reusableFunctions;
import java.io.IOException;

import reusableFunctions.PropertiesReusable;

public class ObjectUtilities {
	

	private static String configFilepath = System.getProperty("user.dir")+"\\Utilities\\LoginConfigs.properties";
	private static PropertiesReusable propertiesReusables;
	public static PropertiesReusable getPropertiesObject(String filePath) throws IOException
	{
		propertiesReusables = new PropertiesReusable(filePath);
		return propertiesReusables;
	}
	
	public static String getConfigFilepath()
	{
		return configFilepath;
	}
}
