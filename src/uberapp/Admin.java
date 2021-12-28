package uberapp;
import uberapp.Driver;
import uberapp.People;

import java.io.IOException;
import java.util.ArrayList;

public class Admin extends People {

	static ArrayList<People> PendingDrivers=new ArrayList<People>();
	Registration adminRegister=new AdminRegister();
	ArrayList<People> AdminList= adminRegister.getList();
	boolean flag=false;
	public Admin(){
		super("","","","");
	}
	public Admin(String id,String pw,String Email,String num)
	{
		super(id,pw,Email,num);
	}
	public void register(People admin) throws IOException {
		adminRegister.register(admin);
	}
	public boolean signIn(String Id, String pass){
		boolean flag=false;
		for(int i=0;i<AdminList.size();i++){
			if(AdminList.get(i).getUserName().equals(Id) && AdminList.get(i).getPassword().equals(pass)){
				flag=true;
			}
		}
		return flag;
	}
	public void addPendingDrivers(People driver)
	{

		PendingDrivers.add(driver);
	}
	public boolean verify(int p) throws IOException
	{
		((Driver)PendingDrivers.get(p-1)).setStatus(true);

		PendingDrivers.remove(p-1);
		return true;
	}
	public void ListPendingDrivers()
	{

		if(PendingDrivers.size()==0)
		{

			flag=false;
		}
		else
		{
			flag=true;
			for(int i=0;i<PendingDrivers.size();i++)
			{
				System.out.println(i+1 +"."+"Name :" + PendingDrivers.get(i).getUserName()+" "+PendingDrivers.get(i).getDrivingLicense()+" "+PendingDrivers.get(i).getNationalID()+" "+PendingDrivers.get(i).getEmail()+" "+PendingDrivers.get(i).getNumber());
			}
		}
	}

	public boolean checkPendingList(){
		if(PendingDrivers.size()==0)
		{
			flag=false;
		}
		else
			flag= true;
		return flag;
	}
}

