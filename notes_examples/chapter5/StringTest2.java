
import java.lang.*;


public class StringTest2
{
    public static void main(String args[])
    {
	String x = "Hello ";
	String y = new String("World!");

	String z = new String(x + y);
	System.out.println(z);
	System.out.printf("The length of this string is %d characters.\n", z.length());

	String c = "Cat";
	String d = "Dog";
	if (c.compareTo(d)<=0)
	{
	   System.out.printf( "%s is less than %s \n", c, d);
	}

	if (c.equals("Cat"))
	{
	   System.out.println("The c object is equal to Cat");
	}
	
	String shout = "HELLO!";
	System.out.println("A bit quieter - " + shout.toLowerCase());
    }
}