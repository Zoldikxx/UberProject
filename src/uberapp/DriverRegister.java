package uberapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DriverRegister implements Registeration 
{
	public void register(people d) throws IOException {
		File DriverFile=new File("C:\\FCI\\TestingFiles");
		boolean result;
		result=DriverFile.createNewFile(); //Creates new file.
		
		// To insert.
		FileInputStream fis  = new FileInputStream(DriverFile);
		try (BufferedReader read = new BufferedReader(new InputStreamReader(fis))) {
		}
			     
		//To retrieve.
		FileOutputStream fos = new FileOutputStream(DriverFile);
		try (PrintWriter write = new PrintWriter(fos)) 
		{
			 String un=d.getUserName()+"\n";
	    	 String un1=d.getPassword()+"\n";
	    	 String un2=d.getNumber()+"\n";
	    	 String un3=d.getEmail()+"\n";
	    	 
	    	 fos.write(un.getBytes());
		     fos.write(un1.getBytes());
		     fos.write(un2.getBytes());
		     fos.write(un3.getBytes());
		     fos.close();
		}
	}

	
}
