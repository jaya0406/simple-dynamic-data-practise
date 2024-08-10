package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileRead {

	protected static String propertyFilepath = System.getProperty("user.dir")+"\\Environment\\Property.properties";
	
	public static Properties propertyread() throws IOException
	{
		File f = new File(propertyFilepath);
		FileInputStream fis = new FileInputStream(f);
		Properties p = new Properties();
		p.load(fis);
		return p;
	}
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		//PropertyFileRead pfr = new PropertyFileRead();
		//pfr.propertyread();
	}

}
