
import java.lang.*;


public class StringTest
{
    public static void main(String args[])
    {
	String x = "Hello ";
	String y = new String("World!");

	String z = new String(x + y);
	System.out.println(z);
	System.out.println("The length of this string is " 
		+ z.length() + " characters.");

	String c = "Cat";
	String d = "Dog";
	if (c.compareTo(d)<=0)
	{
	   System.out.println( c + " is less than " + d);
	}

	if (c.equals("Cat"))
	{
	   System.out.println("The c object is equal to Cat");
	}
	
	String shout = "HELLO!";
	System.out.println("A bit quieter - " + shout.toLowerCase());
    }
}