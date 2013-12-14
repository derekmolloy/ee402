
import java.util.*;

// Write a Java application that reads in a number of strings from the command line and provides a 
// histogram of the numbers of letters in the words passed e.g. if the program was executed as:
// java ArrayApp This is a test string
// it would return 1 word with 1 letters, 1 words with 2 letters, 2 words with 4 letters, 1 words with 6 letters

public class ArrayApp {

	public static void main(String[] args) {
		
		int[] letters = new int[10];
		for(int i=0; i<args.length; i++)
		{
			int currentLength = args[i].length();
			letters[currentLength]++;
		}
		
		for(int i=1; i<letters.length; i++)
		{
			System.out.println("The number of words with " + i + " letters is: " + letters[i]);
		}
	}

}
