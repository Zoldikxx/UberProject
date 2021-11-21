package uberapp;

import java.io.FileNotFoundException;
import java.io.IOException;




public abstract class people {
	private String username;
	private String password;
	private String email;
	private String phoneNumber;
	private String DrivingLicense;
	private String NationalId;
	
	
	public people(String username,String password, String email,String phoneNumber)
	{
		this.username=username;
		this.password=password;
		this.email=email;
		this.phoneNumber=phoneNumber;
	}
	
	/*public people(Registeration reg)
	{
		this.reg=reg;
	}
	public void setReg(Registeration reg) {
		this.reg = reg;
	}*/
	
	public people(String username,String password,String phoneNumber)
	{
		this.username=username;
		this.password=password;
		this.phoneNumber=phoneNumber;
	}
	public void setUserName(String username)
	{
		this.username=username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public void setNumber(String phoneNumber)
	{
		this.phoneNumber=phoneNumber;
	}
	public void setNationalId(String NationalId)
	{
		this.NationalId=NationalId;
	}
	public void setDrivingLicense(String DrivingLicense)
	{
		this.DrivingLicense=DrivingLicense;
	}
	public String getNationalId()
	{
		return NationalId;
	}
	public String getDrivingLicense()
	{
		return DrivingLicense;
	}
	
	
	public String getUserName()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}
	public String getEmail()
	{
		return email;
	}
	public String getNumber()
	{
		return phoneNumber;
	}
	public abstract void signIn(String ID,String PW) throws FileNotFoundException, IOException;
	
}
