package uberapp;

import java.io.IOException;
import java.util.Scanner;

public class DriverMenu {
    public static Driver driver =new Driver();

    public static void driverMenu() throws IOException {
        String choice;
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("1. Register");
            System.out.println("2. Log In");
            System.out.println("3. Go back");
            System.out.println("4. Exit App");
            choice = input.next();

            if (choice.equals("1")) {
                System.out.println("Please enter your UserName: ");
                String UserName = input.next();
                System.out.print("Please enter your password: ");
                String password = input.next();
                System.out.print("Enter your Email (optional): ");
                String email = input.next();
                System.out.print("Please enter your Mobile Number: ");
                String phone = input.next();
                System.out.print("Please enter your NationalID ");
                String NationalID=input.next();
                System.out.print("Please enter your DrivingLicense: ");
                String DrivingLicense=input.next();
                System.out.println("\n");
                driver = new Driver(UserName, password, email, phone,NationalID,DrivingLicense);
                driver.register(driver);
            }
            else if(choice.equals("2")){
                System.out.println("Please enter your UserName: ");
                String UserName=input.next();
                System.out.print("Please enter your password: ");
                String password = input.next();
                if(driver.signIn(UserName,password) && driver.getStatus()){
                    System.out.println("You've logged in successfully");
                    System.out.println();
                    driverSubMenu();
                }
                else if(driver.signIn(UserName,password) && !driver.getStatus()){
                    System.out.println("You are still pending admin approval");
                }
                else
                    System.out.println("Wrong Credentials");
            }
            else if (choice.equals("3")){
                break;
            }
        }
    }
    public static void driverSubMenu() {
        Scanner input = new Scanner(System.in);
        String choice ;
        while (true) {
            System.out.println("================================================");
            System.out.println("Choose from the following: ");
            System.out.println("1.Add Favorite Area");
            System.out.println("2.Remove Favorite Area");
            System.out.println("3.List Requests");
            System.out.println("4.List Requests in favourite area");
            System.out.println("5.Make offer");
            System.out.println("6.Notifications");
            System.out.println("7.Show active rides");
            System.out.println("8.Check balance");
            System.out.println("9.Go back");
            choice = input.next();
            System.out.println("\n");
            if(choice.equals("1")){
                System.out.print("Enter area: ");
                String favarea = input.next();
                driver.addFavArea(favarea);
                System.out.println("Fav area has been added successfully");
            }
            else if(choice.equals("2")){
                System.out.print("Enter area you want to remove: ");
                String favarea = input.next();
                if(driver.removeFavArea(favarea)){
                    System.out.println("Area removed successfully");
                }
            }
            else if(choice.equals("3")){
                driver.listAllRequests();
            }
            else if(choice.equals("4")){
                driver.listRequests(driver);
            }
            else if(choice.equals("5")){
                driver.listAllRequests();
                System.out.println("Enter the ride you want");
                int choice5=input.nextInt();
                System.out.println("Enter the offer you want to make");
                int choice2=input.nextInt();
                driver.AddOffer(choice5, choice2, driver);
            }

            else if(choice.equals("6")){
                driver.listNotification();
            }
            else if(choice.equals("7")){
                if(!driver.checkActiveRides(driver)){
                    System.out.println("You don't have any active rides");
                }
                else{
                    driver.printActiveRides(driver);
                    System.out.println("Do you want to end ride?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int choice2=input.nextInt();
                    if(choice2==1){
                        driver.endRide(driver);
                        System.out.println("Ride has ended");
                        System.out.println("Your balance has been updated");
                    }
                    else
                        break;
                }

            }
            else if (choice.equals("8")){
                float balance=driver.getBalance();
                System.out.println("Your current balance is "+balance);
            }
            else if(choice.equals("9")){
                break;
            }

        }
    }
}
