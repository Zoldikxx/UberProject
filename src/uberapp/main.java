package uberapp;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
public class main
{
	public static void main(String[] args) throws IOException
	{
		Customer c=new Customer("ziad","123456","ziad@email","123456");
		Registeration r=new CustomerRegister();
		c.setrig(r);
		c.register();
		System.out.println("Zoz");
		}
	}
