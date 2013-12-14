package ee402;

import java.util.Arrays;
import java.util.Comparator;  //Comparator Interface

public class SortingObjects {
	
	public static void main(String[] args) {
	
		Comparator<Student> byName = new StudentNameComparator();
		Comparator<Student> byID = new StudentIDComparator();
		
		Student[] students = new Student[]{
			new Student("Derek", 1234),
			new Student("Sarah", 1238),
			new Student("Mick",  1237),
			new Student("Adam",  1233),
			new Student("Jane",  1231)};
				
		// Sort by Name
		Arrays.sort(students, byName);
		System.out.println("The students sorted by name:");
		for (int i=0; i<students.length; i++){
			students[i].display();
		}
		
		// Now sort by ID
		Arrays.sort(students, byID);
		System.out.println("\nThe students sorted by id:");
		for (int i=0; i<students.length; i++){
			students[i].display();
		}
	}
}