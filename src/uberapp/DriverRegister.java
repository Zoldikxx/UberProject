package uberapp;

import uberapp.Registration;

import java.util.ArrayList;

public class DriverRegister implements Registration {
    Admin admin=new Admin();
    static ArrayList<People>driverList=new ArrayList<People>();
    @Override
    public void register(People driver) {
        addPendingtoAdmin(driver);
        driverList.add(driver);

        // ((Driver)driverList.get().setStatus(false);

    }

    @Override
    public ArrayList<People> getList() {
        return driverList;
    }

    public void addPendingtoAdmin(People driver)
    {
        admin.addPendingDrivers(driver);
    }

}
