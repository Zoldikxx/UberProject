package RegisterationSubSystem;

import java.io.BufferedReader; 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import PeopleSubSystem.*;


public class DriverRegister implements Registration
{
	Admin a;
    public void register(People d) throws IOException
    {   
    	addPendingtoAdmin(d);
    	if(((Driver) d).getState())
    	{
        File DriverFile=new File("C:\\FCI\\TestingFiles\\Driver.txt");
        boolean result;
        result=DriverFile.createNewFile(); //Creates new file.

        // To insert.
        FileInputStream fis  = new FileInputStream(DriverFile);
        try (BufferedReader read = new BufferedReader(new InputStreamReader(fis))) {
        }

        //To retrieve.
        FileOutputStream fos = new FileOutputStream(DriverFile,true);
        try (PrintWriter write = new PrintWriter(fos))
        {
            String un=d.getUserName()+"\n";
            String un1=d.getPassword()+"\n";
            String un2=d.getNumber()+"\n";
            String un3=d.getEmail()+"\n";
            String un4=((Driver) d).getNationalID()+"\n";
            String un5=((Driver) d).getDrivingLicense()+"\n";

            fos.write(un.getBytes());
            fos.write(un1.getBytes());
            fos.write(un2.getBytes());
            fos.write(un3.getBytes());
            fos.write(un4.getBytes());
            fos.write(un5.getBytes());
            fos.close();
        }
    	}
    }
    public void setAdmin(Admin a)
    {
    	this.a=a;
    }
    public void addPendingtoAdmin(People p)
    {
    	a.addPendingDrivers(p);
    }
}