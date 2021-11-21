package uberapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Customer extends people{
	Registeration r;

	public Customer(String id, String pw, String num) {
		super(id, pw, num);
	}
	public Customer(String id,String pw, String Email,String num)
	{
		super(id,pw,Email,num);
	}
	
 public void setrig(Registeration r)
 {
	 this.r=r;
 }
	
	public void register() throws IOException {
		r.register(this);
	}
	
	@Override
	public void signIn(String ID,String PW) throws IOException
	{
		try (BufferedReader read = new BufferedReader(new FileReader("CustomerFile"))) 
		{
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
	
	

}
