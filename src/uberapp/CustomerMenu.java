package uberapp;

import java.io.IOException;
import java.util.Scanner;

public class CustomerMenu {
    static Customer customer=new Customer();
    public static void customerMenu() throws IOException {

        String choice="";
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("1. Register");
            System.out.println("2. Log In");
            System.out.println("3. Go back");
            System.out.println("4. Exit App");
            choice = input.next();

            if (choice.equals("1")) {
                System.out.println("Please enter your UserName: ");
                String UserName=input.next();
                System.out.print("Please enter your password: ");
                String password = input.next();
                System.out.print("Enter your Email (optional): ");
                String email = input.next();
                System.out.print("Please enter your Mobile Number: ");
                String phone = input.next();
                System.out.println("\n");
                customer=new Customer(UserName,password,email,phone);
                customer.register(customer);
            }
            else if(choice.equals("2")){
                System.out.println("Please enter your UserName: ");
                String UserName=input.next();
                System.out.print("Please enter your password: ");
                String password = input.next();
                if(customer.signIn(UserName,password)){
                    System.out.println("You've logged in successfully");
                    System.out.println();
                    customerSubMenu();
                }
                else
                    System.out.println("Wrong Credentials");
            }
            else if(choice.equals("3")){
                break;
            }
            else if(choice.equals("4")){
                System.exit(0);
            }
            else
                System.out.println("Enter a valid choice");

        }
    }


    public static void customerSubMenu() {
        String choice = "";
        int choice2 = 0;
        float rating=0;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Please enter a choice:");
            System.out.println("1.Request Ride");
            System.out.println("2.List Offers");
            System.out.println("3.Notifications");
            System.out.println("4.History");
            System.out.println("5.Go back");
            choice = input.next();
            if (choice.equals("1")) {
                System.out.print("Enter pickup source: ");
                String source = input.next();
                System.out.print("Enter drop off destination: ");
                String destination = input.next();
                System.out.println("\n");
                customer.requestRide(customer, source, destination);
            }
            else if (choice.equals("2")) {
                customer.listOffer(customer);
            }
            else if (choice.equals("3")) {
                if (!customer.listNotification()) {
                    System.out.println("No notifications available");
                }
                else
                    customer.listNotification();
            }
            else if (choice.equals("4")) {
                if(!customer.History(customer)){
                    System.out.println("No previous rides");
                }
                else {
                    customer.History(customer);
                    while (true){
                        System.out.println("1. Rate previous ride");
                        System.out.println("2. Go back");
                        choice = input.next();
                        if (choice.equals("1")) {
                            System.out.println("Enter ride number you want to rate");
                            choice2 = input.nextInt();
                            System.out.println("Enter rating");
                            rating=input.nextFloat();
                            customer.rateRide(choice2,rating);
                        }
                        else if(choice.equals("2")){
                            break;
                        }
                        else
                            System.out.println("Enter valid number");
                    }
                }

            }
            else if (choice.equals("5")) {
                break;
            }
            else
                System.out.println("Enter valid choice");
        }
    }
}

