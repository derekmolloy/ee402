package ee402;

public class Student extends Object{

	private String name;
	private int id;
	
	public Student(String name, int id){
	  this.name = name;
	  this.id = id;
	}
	
	public void display(){
	  System.out.println("A student with name: " + name 
	     + " and id " + id);
	}

	public String getName() { return name; }
	public int getID() { return id; }
}