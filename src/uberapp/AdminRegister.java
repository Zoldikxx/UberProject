package uberapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class AdminRegister implements Registeration {
	@Override
	public void register(people a) throws IOException {
		File AdminFile=new File("C:\\FCI\\TestingFiles");
		boolean result;
		result=AdminFile.createNewFile(); //Creates new file.
		// To insert.
		FileInputStream fis  = new FileInputStream(AdminFile);
		try (BufferedReader read = new BufferedReader(new InputStreamReader(fis))) {
		}		     
		//To retrieve.
		FileOutputStream fos = new FileOutputStream(AdminFile);
		try (PrintWriter write = new PrintWriter(fos)) {
		}
		String un=a.getUserName()+"\n";
		String un1=a.getPassword()+"\n";
		String un2=a.getNumber()+"\n";
		String un3=a.getEmail()+"\n";
		
		 fos.write(un.getBytes());
		 fos.write(un1.getBytes());
	     fos.write(un2.getBytes());
	     fos.write(un3.getBytes());
	     fos.close();
	}

}
