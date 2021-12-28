package uberapp;

import java.util.ArrayList;

public class Ride {
    float rating, RideCost;
    boolean state;
    String Source , Destination, title, description, time;
    Customer customer;
    Driver driver;
    Offer offer;
    int indexOffer=0;
    //private int [] Offer=new int[10];
    static ArrayList<Offer> offers = new ArrayList<Offer>();
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
        offer=null;
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
    public void start(int index){
        Ride ride= requests.get(index-1);
        rides.add(ride);
        requests.remove(ride);
    }
    public boolean listHistory(Customer customer){
        boolean flag;

        if(history.size()==0){
            flag =false;
        }
        else {
            flag=true;
            for (int i=0;i< history.size();i++) {
                if(history.get(i).getCustomer().getUserName().equals(customer.getUserName())) {
                    System.out.println("Driver " + history.get(i).getDriver().getUserName());
                    System.out.println("Source: " + history.get(i).getSource());
                    System.out.println("Destination: " + history.get(i).getDestination());
                    System.out.println("Rating: " + history.get(i).getRating() + "\n");
                }

            }
        }

        return flag;
    }
    public void end(Ride ride){
        history.add(ride);
        rides.remove(ride);
        String notification="Ride has ended";
        notifications.UserNotification.add(notification);
    }

    public void listAllRequests(){
        for (int i=0; i<requests.size();i++) {
            System.out.println(i+1+ " " +"Customer: "+requests.get(i).getCustomer().getUserName());
            System.out.println("Source: "+requests.get(i).getSource());
            System.out.println("Destination: "+requests.get(i).getDestination()+"\n");
        }
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
    public Offer getOffer()
    {
        offer.getOffers();
        return offer;
    }
    public void listOffer(Customer customer2)
    {
        if (requests.size()==0)
            System.out.println("Request a ride first then list the offers");
        else
        {
            for(int i=0;i<requests.size();i++)
            {
                if(requests.get(i).getCustomer().getUserName().equals(customer2.getUserName()))
                {
                    System.out.println("Offer: "+ requests.get(i).getOffer().getCost());
                    System.out.println("Driver Name: "+ requests.get(i).getOffer().getDriver().getUserName());
                    System.out.println("Driver Number: "+ requests.get(i).getOffer().getDriver().getNumber());
                    System.out.println("Driver License: "+ requests.get(i).getOffer().getDriver().getDrivingLicense());
                }

            }
        }

    }
}

