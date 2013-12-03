/** TCP finger client - by Derek Molloy ee402.eeng.dcu.ie
    Usage: Finger username@host.com 
*/

package ee402;

import java.io.*;
import java.net.*;

public class Finger
{
	
    public static void main (String args[]) {
      // Check command line arguments
      if (args.length != 1) {
    	  System.err.println ("Invalid number of paramaters:");
    	  System.err.println ("Usage: Finger username@host");
    	  System.exit(1);
      }
      // Check for existence of @ in argument
      else if (args[0].indexOf("@") == -1) {
        System.err.println ("Invalid paramater : syntax user@host");
        System.exit(1);
      }
      // Split command line argument at the @ character
      String username = args[0].substring(0, args[0].indexOf("@") );
      String hostname = args[0].substring(args[0].indexOf("@") +1, args[0].length());
      
      try {
          System.out.println ("Connecting to " + hostname);

          // Create a connection to server
          Socket s = new Socket(hostname, 79);

          // Create input and output streams to socket
          PrintStream out = new PrintStream( s.getOutputStream()) ;
         
          BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

          // Write username to socket output
          out.println(username);

          // Read response from socket
          String line = in.readLine();

          while (line != null) {
               System.out.println ( line );
               // Read next line
               line = in.readLine();
          }
          // Terminate connection
          s.close();                        
       }
       catch (SocketException e) {
          System.err.println ("Socket error : " + e);
       }
       catch (UnknownHostException e) {
          System.err.println ("Invalid host!");
       }
       catch (IOException e) {
          System.err.println ("I/O error : " + e);
       }
   }
}