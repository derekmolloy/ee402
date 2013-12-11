//An example class and application

import java.lang.*;

public class TestClass extends Object
{
   private int x, y=5;

   public TestClass(int z)
   {
      x = z;
   }

   public void display()
   {
	System.out.println("The values of (x,y) are: (" + x + "," + y +")");
   }

   public static void main(String args[])
   {
	TestClass test = new TestClass(10);
	test.display();
   }
}