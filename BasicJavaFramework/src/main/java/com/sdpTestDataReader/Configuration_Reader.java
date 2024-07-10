package com.sdpTestDataReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration_Reader {

	public static Properties p;

	public Configuration_Reader() throws IOException
	{
		File file = new File("C:\\Users\\aswin.mv\\eclipse-workspace\\BasicJavaFramework\\src\\main\\java\\com\\sdptestdata\\property\\Configuration.properties");
		FileInputStream fis = new FileInputStream(file);
		p = new Properties();
		p.load(fis);
	}
	
	public String getTestData(String key)
	{
		return p.getProperty(key);
	}

}
