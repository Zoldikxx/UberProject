package uberapp;


public abstract class People {

	private String username;
	private String password;
	private String email;
	private String phoneNumber;
	private float Balance;
	private String DrivingLicense;
	private String NationalId;
	public People()
	{
		username="";
		password="";
		email="";
		phoneNumber="";
	}

	public People(String username, String password, String email, String phoneNumber) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
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
	public String getDrivingLicense()
	{
		return DrivingLicense;
	}
	public String getNationalID()
	{
		return NationalId;
	}
	public float getBalance(){return Balance;}
	public abstract boolean signIn(String ID,String PW);



}