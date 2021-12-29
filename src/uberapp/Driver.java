package uberapp;

import java.io.IOException;
import java.util.ArrayList;


public class Driver extends People {
    static Registration driverRegister=new DriverRegister();
    ArrayList<People> driverList= driverRegister.getList();
    ArrayList<String> favAreas = new ArrayList<String>();
    Notifications notification=new Notifications();
    private ArrayList<Ride> availableRequests = new ArrayList<Ride>();

    //static People driver= new Driver();
    Ride ride=new Ride();
    Driver drive;
    boolean status=false;
    private float Balance;
    String NationalID;
    String DrivingLicense;

    public Driver()
    {
        Balance=0;
        NationalID="";
        DrivingLicense="";
    }
    public Driver(String id,String pw, String Email,String num,String NationalID,String DrivingLicense)
    {
        super(id,pw,Email,num);
        this.NationalID=NationalID;
        this.DrivingLicense=DrivingLicense;
    }
    public void register(People driver) throws IOException {
        driverRegister.register(driver);
    }
    public void listAllRequests(){
        ride.listAllRequests();
    }
    public void listRequests(Driver driver){
        ride.listRequests(driver);
    }

    /*public ArrayList<Ride> getRides()
    {
        return availableRequests;
    }*/
    public void AddOffer(int index, int cost, Driver driver)
    {
        ride.makeOffer(index, cost, driver);
    }
    public boolean checkActiveRides(Driver driver){
       return ride.ActiveRides(driver);
    }
    public void printActiveRides(Driver driver){
        ride.printActiveRides(driver);
    }
    public boolean signIn(String Id,String Pass)
    {
        boolean flag=false;
        for(int i=0;i<driverList.size();i++){
            if(driverList.get(i).getUserName().equals(Id) && driverList.get(i).getPassword().equals(Pass) ){
                flag=true;
            }
        }
        return flag;
    }
    public void listNotification(){
        notification.listDriverNotification();
    }
    public void endRide(Driver driver){
       ride.end(driver);
    }
    public void setBalance(float balance) {
        Balance = balance;
    }
    public float getBalance(){
        return Balance;
    }
    public void addFavArea(String area){
        favAreas.add(area);
    }

    public boolean removeFavArea(String area){
        if(!favAreas.remove(area)){
            System.out.println("Area not found");
            return false;
        }
        else
            return true;
    }

    public boolean getStatus(){return status;}
    public void setStatus(boolean status){this.status=status;}
    public ArrayList<String> getFavArea(){
        return favAreas;
    }
    public String getDrivingLicense()
    {
        return DrivingLicense;
    }
    public String getNationalID()
    {
        return NationalID;
    }

}
