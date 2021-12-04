package uberapp;
import java.io.IOException; 
import java.util.ArrayList;
import java.util.Scanner;
import PeopleSubSystem.*;
import RegisterationSubSystem.*;
import RideSubSystem.*;

//Ziad Mohamed 20196024
//Aliaa Ehab 20196081
//Jana Hossam 20196015
public class Main
{
	public static void main(String[] args) throws IOException
	{
		 ArrayList<Driver> drivers = new ArrayList<Driver>();
		 try (Scanner input = new Scanner(System.in)) {
			String choice;
			 Admin a=new Admin("admin","123456","admin@email","123456");
			 Registration a1 =new AdminRegister();
			 a.setrig(a1);
			 a.register();
			while(true)
			{
				System.out.println("Please Choose a type");
				System.out.println("1-Customer");
				System.out.println("2-Driver");
				System.out.println("3-Admin");
				choice = input.next();
				if(choice.equals("1"))
				{
					System.out.println("Please Choose one of the following");
			        System.out.println("1- Register");
			        System.out.println("2- Login");
			        choice = input.next();
			        System.out.println("\n");
			        if(choice.equals("1"))
			    {  
			    	System.out.println("Please enter your UserName: ");
					String UserName=input.next();
					System.out.print("Please enter your password: ");
			        String password = input.next();
			        System.out.print("Enter your Email (optional): ");
			        String email = input.next();
			        System.out.print("Please enter your Mobile Number: ");
			        String phone = input.next();
			        System.out.println("\n");
			        Customer c=new Customer(UserName,password,email,phone);
			        Registration r=new CustomerRegister();
					c.setrig(r);
					c.register();
					System.out.print("\n");    
				}
			        else if(choice.equals("2"))
			    	{
			    		System.out.println("Please enter your UserName: ");
			    		String UserName=input.next();
			    		System.out.print("Please enter your password: ");
			            String password = input.next();
			            System.out.print("Please enter your PhoneNumber ");
			            String PhoneNumber = input.next();
			            Customer c=new Customer(UserName,password,PhoneNumber);
			            if(c.signIn(UserName, password))
			    		{
			    			System.out.println("You've logged in succefully");
			    			System.out.println("Please enter a choice:");
			                System.out.println("1.Request Ride");
			                System.out.println("2.List Offers");
			                System.out.println("3.Exit");
			                String choice2 = input.next();
			                System.out.println("\n");
			                    switch(choice2){
			                        case "1":
			                            System.out.print("Enter A Source: ");
			                            String source = input.next();
			                            System.out.print("Enter A Destination: ");
			                            String destination = input.next();
			                            System.out.println("\n");
			                            c.request(c,source, destination); //To request a ride giving src,dest
			                            break;
			                        case "2":
			                        	//Do Something.
			                        	System.out.println("Waiting for Sprint 2");
			                        	break;
			                        case "3":
			                        	System.exit(0);
			                        default:
			                        	System.out.println("Wrong choice");
			                        	
			    		}
			    	}
			        else{
			            System.out.println("Wrong Choice");
			            break;
			        }
				}
			}
				else if(choice.equals("2"))
				{
					System.out.println("Please Choose one of the following");
			        System.out.println("1- Register");
			        System.out.println("2- Login");
			        choice = input.next();
			        System.out.println("\n");
			        if(choice.equals("1"))
			    {  
			    	System.out.println("Please enter your UserName: ");
					String UserName=input.next();
					System.out.print("Please enter your password: ");
			        String password = input.next();
			        System.out.print("Please enter your Email (optional): ");
			        String email = input.next();
			        System.out.print("Please enter your Mobile Number: ");
			        String phone = input.next();
			        System.out.print("Please enter your NationalID ");
			        String NationalID=input.next();
			        System.out.print("Please enter your DrivingLicense: ");
			        String DrivingLicense=input.next();
			        System.out.println("\n");
			        Registration r=new DriverRegister();
			        ((DriverRegister) r).setAdmin(a);
			        Driver d=new Driver(UserName,password,email,phone,NationalID,DrivingLicense);
			        d.setrig(r);
			        d.register();
			        drivers.add(d);
			        
				}
			        else if(choice.equals("2"))
			        {
			        	System.out.println("Please enter your UserName: ");
			    		String UserName=input.next();
			    		System.out.print("Please enter your password: ");
			            String password = input.next();
			            System.out.print("Please enter your PhoneNumber ");
						String PhoneNumber = input.next();
			            System.out.println("Please enter your NationalID ");
			    		String NationalID=input.next();
			    		System.out.println("Please enter your DrivingLicense ");
			    		String DrivingLicense=input.next();
			            Driver d=new Driver(UserName,password,PhoneNumber,NationalID,DrivingLicense);
			            if(d.signIn(UserName, password))
			            {
			            	System.out.println("You've logged in succefully");
			            	for(int i=0;i<drivers.size();i++)
			            	{
			            		if(drivers.get(i).getUserName().equals(d.getUserName()))
			            		{
			            			d=drivers.get(i);
			            		}
			            	}
			            	 System.out.println("Choose from the following: ");
					            System.out.println("1.Add Favorite Area");
					            System.out.println("2.Remove Favorite Area");
					            System.out.println("3.List Requests");
					            System.out.println("4.Create Offer");
					            System.out.println("5.Exit");
					            String choice2 = input.next();
					            System.out.println("\n");
					            switch(choice2)
					            {
					            case "1":
					            	System.out.print("Enter your fav Area: ");
					                d.addFavArea(input.next());
					                break;
					            case "2":
					            	System.out.print("Enter The Area: ");
					                d.removeFavArea(input.next());
					                break;
					            case "3":
					            	System.out.println("Ride requests: ");
					            	d.listRequests();                    	
					            	break;
					            case "4":
					            	 ArrayList<Ride> availableRequests = d.getRides();
					            	 System.out.println("Please enter the ride cost: ");
					            	 int cost=input.nextInt();
					            	 availableRequests.get(0).AddOffer(cost, d);
					            	 break;
					            case "5":
					            	System.exit(0);
					            }
			            }
			           
			        }
					
}
				else if(choice.equals("3"))
						{	
							System.out.println("1- List pending requests");
							int choice6=input.nextInt();
							
							if(drivers.size()==0)
							{
								System.out.println("No requests are available");
								continue;
							}
							if(choice6==1)
							{
								a.ListDrivers();
							}
							System.out.println("Please enter the number of driver you want to verify");
							int i=input.nextInt();
							a.verify(i);
							drivers.remove(i-1);
					        System.out.println("The admin has verified you");
						}
				else
				{
					System.out.println("Wrong choice!");
				}
}
		}
	}
}
