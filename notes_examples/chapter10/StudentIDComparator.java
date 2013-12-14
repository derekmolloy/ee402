package ee402;
import java.util.Comparator;

public class StudentIDComparator implements Comparator<Student> {

	public int compare(Student a, Student b) {
	  if (a.getID() < b.getID()) return -1;
	  else if (a.getID() > b.getID()) return 1;
	  else return 0;
	}
}