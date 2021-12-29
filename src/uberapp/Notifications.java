package uberapp;

import java.util.ArrayList;

public class Notifications {
    static ArrayList<String> UserNotification= new ArrayList<String>();
    static ArrayList<String> DriverNotification= new ArrayList<String>();
    public boolean listUserNotification(){
        boolean flag;
        if(UserNotification.size()==0){
            flag=false;
        }
        else{
            flag=true;
            for(int i=0; i<UserNotification.size();i++){
                System.out.println((i+1)+". "+UserNotification.get(i)+"\n");
            }
        }
        return flag; }
    public boolean listDriverNotification(){
        boolean flag;
        if(DriverNotification.size()==0){
            flag=false;
        }
        else {
            flag=true;
            for (int i = 0; i < DriverNotification.size(); i++) {
                System.out.println((i + 1) + ". " + DriverNotification.get(i)+"\n");
            }
        }
        return flag;}
}

