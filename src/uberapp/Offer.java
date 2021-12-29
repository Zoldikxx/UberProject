package uberapp;

import java.util.ArrayList;

public class Offer extends ArrayList<Offer> {
    private int cost;
    private Driver driver;
    ArrayList<Offer> offers = new ArrayList<Offer>();
    public Offer(int cost,Driver driver){
        this.cost=cost;
        this.driver=driver;
    }
    public Offer() {
        cost=0;
        driver=null;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public ArrayList <Offer> getOffers() {
        return offers;
    }

}
