package PeopleSubSystem;

import java.io.BufferedReader; 
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import RideSubSystem.Ride;
import RegisterationSubSystem.*;
public class Customer extends People{
    static Registration r=new CustomerRegister();

    public Customer(String id, String pw, String num) {
        super(id, pw, num);

    }
    public Customer(String id,String pw, String Email,String num)
    {
        super(id,pw,Email,num);
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
    public void request(Customer c,String src, String dst){
    	Ride r=new Ride(c,src,dst);
        r.StartRequest(this, src, dst);
    }
    public void notifyNewOffer(int offer,Driver d)
    {
    	System.out.println("New Offer has been added"+ offer +"from: " + d.getUserName());
    }

    @Override
    	public boolean signIn(String ID,String PW) throws IOException
    	{
    	boolean flag=false;
    	File files=new File("C:\\FCI\\TestingFiles\\Customer.txt");
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
    