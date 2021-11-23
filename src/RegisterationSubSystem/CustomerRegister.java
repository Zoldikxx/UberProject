package RegisterationSubSystem;

import java.io.BufferedReader; 
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import PeopleSubSystem.*;
import java.io.*;

public class CustomerRegister implements Registration
{
    //@Override
    public void register(People c) throws IOException
    {
        File CustomerFile=new File("C:\\FCI\\TestingFiles\\Customer.txt");
        boolean result;
        result=CustomerFile.createNewFile(); //Creates new file.
        
        // To insert.
        FileInputStream fis  = new FileInputStream(CustomerFile);
        try (BufferedReader read = new BufferedReader(new InputStreamReader(fis))) {
        }

        //To retrieve.
        FileOutputStream fos = new FileOutputStream(CustomerFile,true);
        try (PrintWriter write = new PrintWriter(fos))
        {
            String un=c.getUserName()+"\n";
            String un1=c.getPassword()+"\n";
            String un2=c.getNumber()+"\n";
            String un3=c.getEmail()+"\n";

            fos.write(un.getBytes());
            fos.write(un1.getBytes());
            fos.write(un2.getBytes());
            fos.write(un3.getBytes());
            fos.close();
        }
        System.out.print("Registered successfully");
    }
}