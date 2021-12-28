package uberapp;

import java.io.IOException;
import java.util.Scanner;

//Ziad Mohamed 20196024
//Aliaa Ehab 20196081
//Jana Hossam 20196015
public class main {

	public static void main(String[] args) throws IOException
	{
		String choice;
		Scanner input = new Scanner(System.in);
		while(true)
		{

			System.out.println("Please Choose a type");
			System.out.println("1. Admin");
			System.out.println("2. Customer");
			System.out.println("3. Driver");
			choice = input.next();
			if(choice.equals("1")){
				AdminMenu.adminMenu();
			}
			else if(choice.equals("2")){
				CustomerMenu.customerMenu();
			}
			else if(choice.equals("3")){
				DriverMenu.driverMenu();
			}
			else
				System.out.println("Enter valid choice");
		}

	}
}
