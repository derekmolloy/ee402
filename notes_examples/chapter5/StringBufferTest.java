
import java.lang.*;


public class StringBufferTest
{
   public static void main(String args[])
   {
	String s = new String("Hello World!");
	StringBuffer buffer = new StringBuffer(s);

	buffer.insert(5, " to the");

	String t = buffer.toString();
	System.out.println(t);
   }
}