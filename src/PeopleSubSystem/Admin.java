package PeopleSubSystem;

import java.io.BufferedReader; 
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import RegisterationSubSystem.*;

public class Admin extends People{
	static ArrayList<People>PendingDrivers=new ArrayList<People>();
	public void addPendingDrivers(People d)
	{
		PendingDrivers.add((Driver)d);
	}
	public People getPendingDriver()
	{
		People p;
		if(PendingDrivers.size()!=0)
		{
		p=PendingDrivers.get(PendingDrivers.size()-1);
		PendingDrivers.remove(PendingDrivers.size()-1);
		
		return p;
		}
			return null;
	}
	public void setrig(Registration r)
    {
        this.r=r;
    }

    public void register() throws IOException {
        r.register(this);
    }
	public void verify(int p) throws IOException
	{
		((Driver)PendingDrivers.get(p-1)).setState(true);
		((Driver)PendingDrivers.get(p-1)).register();
		PendingDrivers.remove(p-1);
		
	}
	public void ListDrivers()
	{
		if(PendingDrivers.size()==0)
		{
			System.out.println("No requests are available ");
		}
		else
		{
			for(int i=0;i<PendingDrivers.size();i++)
			{ 	
				System.out.println(i+1 +"-->"+"Name :" + PendingDrivers.get(i).getUserName()+" "+"Password : "+ PendingDrivers.get(i).getPassword());	
			}
		}
	}
	 Registration r;
	 public Admin(String id,String pw,String num) 
	 {
		  super(id, pw, num);
	 }
    public Admin(String id,String pw,String Email,String num)
    {
        super(id,pw,Email,num);
    }
    @Override
    public boolean signIn(String ID,String PW) throws IOException
	{
	boolean flag=false;
	File files=new File("C:\\FCI\\TestingFiles\\Admin.txt");
	Reader reader=new FileReader(files);
    try (BufferedReader read =new BufferedReader(reader))
    {
        String line="";
        while((line=read.readLine()) !=null)
        {
            if (line.equals(ID))
            {  
            	flag=true;
            	break;
            }   
        }
        while((line=read.readLine()) !=null)
        {
            if (line.equals(PW))
            {  
            	flag=true;
            	break;
            }   
        }
	return flag;
	}
	}
}