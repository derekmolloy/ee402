package ee402;

import java.util.*;

public class GenericsTest {

	public static void main(String args[])
	{
	    // Populate a Vector using an array of Students
	    Student[] studentArray = new Student[]{
	      new Student("Derek", 1234),
	      new Student("Tom", 1235),
	      new Student("Jane", 1236),
	      new Student("Jill", 1237)
	    };
	    
	    Vector<Student> students = new Vector<Student>(10);
	    students.addAll(Arrays.asList(studentArray));
	    
	    // Iterate the usual way
	    System.out.println("The Usual Way:");
	    for (int i=0; i<students.size(); i++)
	    {
	      Student tempStudent = students.elementAt(i);
	      System.out.print(tempStudent.getName() + ", ");
	    }
	    
	    // Iterate using an Enumeration
	    System.out.println("\nUsing an Enumeration:");        
	    Enumeration<Student> e = students.elements();
	    while(e.hasMoreElements())
	    {
	      Student tempStudent = e.nextElement();
	      System.out.print(tempStudent.getName() + ", ");
	    }
	    
	    // Using the "enhanced for"
	    System.out.println("\nUsing the enhanced For:");
	    for(Student tempStudent : students)
	    {
	      System.out.print(tempStudent.getName() + ", ");
	    }
	}
}