package uberapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Admin extends people{

	public Admin(String id,String pw, String Email,String num)
	{
		super(id,pw,Email,num);
	}
	Registeration r;
	public void register() throws IOException {
		r.register(this);
	}

	@Override
	public void signIn(String ID,String PW) throws IOException
	{
		BufferedReader read = new BufferedReader(new FileReader("AdminFile"));
		String line="";	
		while((line=read.readLine()) !=null)
	    {
	   	 if (ID.equals(line))
	   	 {
	   		 if(PW.equals(line))
	   			 System.out.println("logged in succesfully");
	   		 else
	   			System.out.println("Password Incorrect");
	   	 }
	   	 else
	   		System.out.println("UserName Incorrect");
	    }
	}
	

}
