/* Java WhoIs Example - Written by Derek Molloy for the EE402 Module
 * See: ee402.eeng.dcu.ie
 */

package ee402;

import java.net.*;

public class JavaWhoIs {

	public static void main(String[] args) {
		if (args.length!=1){
			System.out.println("Usage is:  WhoIs [hostname]");
			System.exit(0);
		}
		try{
			InetAddress i = InetAddress.getByName(args[0]);
			System.out.println("The Address is: " + i.getHostAddress().toString());
		}
		catch(UnknownHostException e){
			System.out.println("Unknown Host");
		}
	}
	
}
