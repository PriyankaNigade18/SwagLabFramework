package com.SwagLabs.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil
{
	public Properties p1;
	public PropertiesUtil()
	{
			File f1=new File(System.getProperty("user.dir")+"\\Config.properties");
		  FileInputStream fs;
		  p1= new Properties();
		  try {
			fs=new FileInputStream(f1);
			 p1.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}
	
	//method
	public String getData(String key)
	{
		return p1.getProperty(key);
	}
	
	
	
	
	
}
