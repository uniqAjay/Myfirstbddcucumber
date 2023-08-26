package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigue {
	
String path = "configue.properties";
 
	Properties ReadProperties;
	
	public ReadConfigue() throws IOException {
		
		ReadProperties = new Properties();
	    
		FileInputStream file = new FileInputStream(path);
		ReadProperties.load(file);
		
	}
	



public String GetBrowserValue() { 
	String Value =  ReadProperties.getProperty("browser");
	 
	if(Value!=null) 
		
		return Value;
		
	else 
		
		throw new RuntimeException("url not specified in configue file");
}
	    


}
