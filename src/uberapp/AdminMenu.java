package uberapp;

import java.io.IOException;
import java.util.Scanner;

public class AdminMenu {
    public static Admin admin=new Admin();
    public static void adminMenu() throws IOException {
        String choice="";

        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("1. Register");
            System.out.println("2. Log In");
            System.out.println("3. Go back");
            System.out.println("4. Exit App");
            choice=input.next();

            if(choice.equals("1")){

                System.out.println("Please enter your UserName: ");
                String UserName=input.next();
                System.out.print("Please enter your password: ");
                String password = input.next();
                System.out.print("Enter your Email (optional): ");
                String email = input.next();
                System.out.print("Please enter your Mobile Number: ");
                String phone = input.next();
                System.out.println("\n");
                admin=new Admin(UserName,password,email,phone);
                admin.register(admin);
            }
            else if(choice.equals("2")){
                System.out.println("Please enter your UserName: ");
                String UserName=input.next();
                System.out.print("Please enter your password: ");
                String password = input.next();
                if(admin.signIn(UserName,password)){
                    System.out.println("You've logged in successfully");
                    adminSubMenu();
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
    public static void adminSubMenu() throws IOException {
        String choice="";
        int choice2=0;
        Admin admin=new Admin();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("1. List pending requests");
            System.out.println("2. Go Back");
            choice = input.next();
            if (choice.equals("1")) {
                if (!admin.checkPendingList()) {
                    System.out.println("There are no pending drivers ");
                }
                else if(admin.checkPendingList()){
                    admin.ListPendingDrivers();
                    System.out.println("Choose Driver to verify");
                    choice2 = input.nextInt();
                    if (admin.verify(choice2)) {
                        System.out.println("Driver verified successfully");
                    } else
                        System.out.println("Couldn't verify driver");
                }

            }
            else if(choice.equals("2")){
                break;
            }
            else
                System.out.println("Enter a valid choice");
        }

    }
}
