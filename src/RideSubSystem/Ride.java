package RideSubSystem;

import java.util.ArrayList;

import PeopleSubSystem.*;

public class Ride {
    static int RideID=0;
    double RideCost;
    String Source , Destination;
    Customer customer;
    private int [] Offer=new int[10];
    int indexOffer=0;
    private static ArrayList<Driver> drivers = new ArrayList<Driver>();
   public Ride(Customer customer,String Source,String Destination){
	    this.customer=customer;
        this.Destination=Destination;
        this.Source= Source;
        RideID++;
    }
   public static void addDriver(Driver d){
       drivers.add(d);
   }
   public static void removeDriver(Driver d){
       drivers.remove(d);
   }
   public void StartRequest(Customer c, String src, String dst){
       for (Driver driver : drivers) {
    	   ArrayList<String> temp=driver.getFavAreas();
    	   for(int i=0;i<temp.size();i++)
    	   {
           if(temp.get(i).equals(src))
               driver.recieveRequest(c, src, dst);
    	   }
       }
   }
   public void AddOffer(int offer,Driver d)
   {
	   Offer[indexOffer]=offer;
	   indexOffer++;
	   customer.notifyNewOffer(offer, d);
   }
   public void setCustomer(Customer customer){
       this.customer = customer;
   }
   public Customer getCustomer(){
       return customer;
   }
    public String getDestination()
    {
        return Destination;
    }
    public void setDestination( String Destination)
    {
        this.Destination=Destination;
    }
    public String getSource()
    {
        return Source;
    }
    public void setSource(String Source)
    {
        this.Source=Source;
    }
}
