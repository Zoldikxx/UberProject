
package PeopleSubSystem;
import java.util.ArrayList;

import RegisterationSubSystem.DriverRegister;
import RegisterationSubSystem.Registration;
import RideSubSystem.Ride;
import RegisterationSubSystem.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Driver extends People{
	private ArrayList<String> favAreas = new ArrayList<String>();
	private ArrayList<Ride> availableRequests = new ArrayList<Ride>();
	
	static Registration r=new DriverRegister();
	boolean state=false;
	
    private double Balance;
    String NationalID;
    String DrivingLicense;
    public Driver(String id, String pw, String num,String NationalID,String DrivingLicense)
    {
        super(id, pw, num);
        this.NationalID=NationalID;
        this.DrivingLicense=DrivingLicense;
        Ride.addDriver(this);
    }

    public Driver(String id,String pw, String Email,String num,String NationalID,String DrivingLicense)
    {
        super(id,pw,Email,num);
        this.NationalID=NationalID;
        this.DrivingLicense=DrivingLicense;
        Ride.addDriver(this);
    }
    public void addFavArea(String area){
        favAreas.add(area);
    }
    public void removeFavArea(String area){
        if(!favAreas.remove(area)){
            System.out.println("Area not found");
        }
    }
    public void recieveRequest(Customer c, String src, String dst){
        System.out.println("A new request was recieved from " + c.getUserName() + " !\n");
        availableRequests.add(new Ride(c, src, dst));
    }
    public ArrayList<String> getFavAreas(){
        return favAreas;
    }
    public void listRequests(){
        for (Ride r : availableRequests) {
            System.out.println("Customer: "+r.getCustomer().getUserName());
            System.out.println("Source: "+r.getSource());
            System.out.println("Destination: "+r.getDestination()+"\n");
        }
    }
    public ArrayList<Ride> getRides()
    {
 	   return availableRequests;
    }
    public void AddOffer(Ride r,int cost)
    {
    	r.AddOffer(cost, this);
    }
    public void setrig(Registration r)
    {
        this.r=r;
    }
    public void register() throws IOException {
        r.register(this);
    }
    public Registration getRegs()
    {
    	return r;
    }
    public void setBalance(double balance) {
        Balance = balance;
    }
    public double getBalance() {
        return Balance;
    }
    public void setState(boolean state)
    {
    	this.state=state; 	
    }
    public boolean getState()
    {
    	return state;
    }
    public String getNationalID()
    {
    	return NationalID;
    }
    public String getDrivingLicense()
    {
    	return DrivingLicense;
    }
    
    @Override
    public boolean signIn(String ID,String PW) throws IOException
	{
	boolean flag=false;
	File files=new File("C:\\FCI\\TestingFiles\\Driver.txt");
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