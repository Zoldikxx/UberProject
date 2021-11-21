package uberapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver extends people{

	private double Balance;
	
	public void setBalance(double balance) {
		Balance = balance;
	}
	public double getBalance() {
		return Balance;
	}

	public Driver(String id, String pw, String num) 
	{
		super(id, pw, num);
	}
	
	public Driver(String id,String pw, String Email,String num)
	{
		super(id,pw,Email,num);
	}

	@Override
	public void signIn(String ID,String PW) throws IOException
	{
		try (BufferedReader read = new BufferedReader(new FileReader("DriverFile"))) {
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
