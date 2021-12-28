package uberapp;

import java.io.IOException;
import java.util.ArrayList;


public class Customer extends People {

    static Registration customerRegister=new CustomerRegister();
    ArrayList<People> customerList= customerRegister.getList();
    static   People customer =new Customer();
    Ride ride=new Ride();
    Notifications notification=new Notifications();
    public Customer(){

        super("","","","");
    }

    public Customer(String id,String pw, String Email,String num)
    {

        super(id,pw,Email,num);
    }
    public void register(People customer) throws IOException {
        customerRegister.register(customer);
    }
    @Override
    public boolean signIn(String Id, String Pass) {
        boolean flag=false;
        for(int i=0;i<customerList.size();i++){

            if(customerList.get(i).getUserName().equals(Id) && customerList.get(i).getPassword().equals(Pass) ){
                flag=true;
            }
        }
        return flag;
    }
    public void requestRide(Customer customer, String source, String Destination){
        Ride ride=new Ride(customer,source,Destination);
        ride.request(ride);
    }

    /*public void notifyNewOffer(int offer,Driver d)
    {
    	System.out.println("New Offer has been added"+ offer +"from: " + d.getUserName());
    }*/
    public boolean listNotification(){
        return notification.listUserNotification();
    }
    public boolean History(Customer customer){
        return ride.listHistory(customer);
    }
    public void rateRide(int index,float rating){
        ride.rating(index,rating);
    }
    public void acceptOffer(){
        // ride.start();
    }
    public void listOffer(Customer customer){
        ride.listOffer(customer);
    }

}
