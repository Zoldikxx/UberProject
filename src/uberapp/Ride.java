package uberapp;

import java.util.ArrayList;

public class Ride {
    float rating, RideCost;
    boolean state;
    String Source , Destination, title, description, time;
    Customer customer;
    Driver driver;
    static Offer offer=new Offer();
    static ArrayList<Offer>offers=offer.getOffers();

    int indexOffer=0;
    //private int [] Offer=new int[10];
    //static ArrayList<Offer> offers = new ArrayList<Offer>();
    static ArrayList<Ride> rides= new ArrayList<Ride>();
    static ArrayList<Ride> requests= new ArrayList<Ride>();
    static ArrayList<Ride> history= new ArrayList<Ride>();
    Notifications notifications=new Notifications();

    Ride(){
        rating=0;
        RideCost=0;
        customer=null;
        driver=null;
        Source="";
        Destination=" ";
        state=false;
        //offer=null;
    }
    public Ride(Customer customer,String Source,String Destination){
        this.customer=customer;
        this.Destination=Destination;
        this.Source= Source;
        this.rating=0;
        this.state= false;
        this.driver=null;
    }
    public void request(Ride ride){
        requests.add(ride);
    }
    public boolean ActiveRides(Driver driver3){
        boolean flag=false;
        if(rides.size()==0){
             flag=false;
        }
        else {
            for(int i=0;i< rides.size();i++) {
                if (driver3.getUserName().equals(rides.get(i).getDriver().getUserName()))
                { flag = true;}
                else
                    flag=false;
            }
        }
        return flag;
    }
    public void printActiveRides(Driver driver5){
        for(int i=0;i< rides.size();i++) {
            if(driver5.getUserName().equals(rides.get(i).getDriver().getUserName())){
                System.out.println("Customer Name: "+rides.get(i).getCustomer().getUserName());
                System.out.println("Source: "+rides.get(i).getSource());
                System.out.println("Destination: "+rides.get(i).getDestination());
                System.out.println("ETA: 45 minutes");
            }
        }

    }
    public boolean checkHistory(Customer customer){
        boolean flag=false;
        if(history.size()==0){
            flag =false;
        }
        else{
            for (int i=0;i< history.size();i++) {
                if(history.get(i).getCustomer().getUserName().equals(customer.getUserName())) {
                   flag=true;
                }
            }
        }
        return flag;
    }
    public void listHistory(Customer customer){
            for (int i=0;i< history.size();i++) {
                if(history.get(i).getCustomer().getUserName().equals(customer.getUserName())) {
                    System.out.println("Driver " + history.get(i).getDriver().getUserName());
                    System.out.println("Source: " + history.get(i).getSource());
                    System.out.println("Destination: " + history.get(i).getDestination());
                    System.out.println("Rating: " + history.get(i).getRating() + "\n");
                }

            }
    }
    public void end(Driver driver2){
        for(int i=0;i< rides.size();i++) {
            if(driver2.getUserName().equals(rides.get(i).getDriver().getUserName())){
                history.add(rides.get(i));
                float Balance=driver2.getBalance()+rides.get(i).RideCost;
                rides.remove(rides.get(i));
                driver2.setBalance(Balance);
                String notification="Ride has ended";
                notifications.UserNotification.add(notification);
                notifications.DriverNotification.add(notification);
            }
        }
       /* history.add(ride);
        rides.remove(ride);
        float Balance=ride.getDriver().getBalance()+ride.getCost();
        ride.getDriver().setBalance(Balance);
        String notification="Ride has ended";
        notifications.UserNotification.add(notification);*/
    }
    public void listAllRequests(){
        for (int i=0; i<requests.size();i++) {
            System.out.println(i+1+ ". " +"Customer: "+requests.get(i).getCustomer().getUserName());
            System.out.println("  Source: "+requests.get(i).getSource());
            System.out.println("  Destination: "+requests.get(i).getDestination()+"\n");
            System.out.println("  Phone Number: "+requests.get(i).getCustomer().getNumber());
        }
    }
    public boolean checkRequests(){
        if(requests.size()==0){
            return false;
        }
        else
            return true;
    }
    public boolean checkFavRequests(Driver driver1){
        boolean flag=false;
        ArrayList<String> temp=driver1.getFavArea();
        if(requests.size()==0 ){
            flag= false;
        }
        else if (temp.size()==0) {
            flag= false;
        }

        else{
            for(int i=0;i<requests.size();i++){
                for(String area: driver1.favAreas) {
                    if (requests.get(i).getSource().equals(area)) {
                       flag= true;
                    }
                }
            }
        }
        return flag;
    }
    public void listRequests(Driver driver1){
        for(int i=0; i<requests.size();i++){
            for(String area: driver1.favAreas) {
                if (requests.get(i).getSource().equals(area)) {
                    System.out.println(i+1+ " " + "Customer: " + requests.get(i).getCustomer().getUserName());
                    System.out.println("Source: " + requests.get(i).getSource());
                    System.out.println("Destination: " + requests.get(i).getDestination() + "\n");
                }
            }
        }
    }
    public void makeOffer(int index, int cost, Driver driver2){
        offer= new Offer(cost,driver2);
        requests.get(index-1).offers.add(offer);
        //offers.get(index-1).driver=d;
        String driverName=driver2.getUserName();
        String driverNumber=driver2.getNumber();
        String driverLicense=driver2.getDrivingLicense();
        String notification="A new offer was made by "+driverName +"\n"+ "Phone Number:" +driverNumber +"\n"+"Driving License:"+ driverLicense;
        notifications.UserNotification.add(notification);

    }
    public void rating(int index,float rating){
        history.get(index-1).rating=rating;
    }
    public Customer getCustomer(){
        return customer;
    }
    public Driver getDriver(){
        return driver;
    }
    public String getSource()
    {
        return Source;
    }
    public String getDestination()
    {
        return Destination;
    }
    public float getRating(){
        return rating;
    }
    public float getCost(){return RideCost;}
    public ArrayList<Offer> getOffer(){

        return offers;
    }
    public boolean checkforOffer(Customer customer2){
        boolean flag=false;
        if (requests.size()==0)
            flag= false;
        else {
            for(int i=0;i<requests.size();i++) {
                if (requests.get(i).getCustomer().getUserName().equals(customer2.getUserName()));
                flag= true;
            }
        }
        return flag;
    }
    public void listOffer(Customer customer2){

            for(int i=0;i<requests.size();i++)
            {
                if(requests.get(i).getCustomer().getUserName().equals(customer2.getUserName()))
                {
                    for(int j=0;j<offers.size();j++){

                    System.out.println((i+1)+". Offer: "+ requests.get(i).getOffer().get(j).getCost());
                    System.out.println("Driver Name: "+ requests.get(i).getOffer().get(j).getDriver().getUserName());
                    System.out.println("Driver Number: "+ requests.get(i).getOffer().get(j).getDriver().getNumber());
                    System.out.println("Driver License: "+ requests.get(i).getOffer().get(j).getDriver().getDrivingLicense()+"\n");
                }
                }
            }


    }
    public void acceptOffer(int indexOffer,Customer customer){
        String notification="Your Offer was accepted";
        for(int i=0;i<requests.size();i++)
        {
            if(requests.get(i).getCustomer().getUserName().equals(customer.getUserName()))
            {
                    requests.get(i).RideCost= requests.get(i).getOffer().get(indexOffer-1).getCost();
                    requests.get(i).driver= requests.get(i).getOffer().get(indexOffer-1).getDriver();
                    requests.get(i).state=true;
                    start(i);
            }
        }
        notifications.DriverNotification.add(notification);


    }
    public void start(int index){
        Ride ride= requests.get(index);
        rides.add(ride);
        requests.remove(ride);
        String notification="Your ride has started";
        notifications.DriverNotification.add(notification);
        notifications.UserNotification.add(notification);

    }
}

