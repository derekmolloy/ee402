package ee402;

import java.io.*;

public class BasicLEDExample {

	private static String LED0_PATH = "/sys/class/leds/beaglebone:green:usr0";
	
	public static void main(String[] args) {
		
		if(args.length!=1) {
			System.out.println("Incorrect Usage - use:\n\t BasicLEDExample On \n\t BasicLEDExample Off");
			System.exit(0);
		}
		try{
			if (args[0].equalsIgnoreCase("On") || args[0].equalsIgnoreCase("Off")){
				BufferedWriter bw = new BufferedWriter ( new FileWriter (LED0_PATH+"/trigger"));
				bw.write("none");
				bw.close();
				bw = new BufferedWriter ( new FileWriter (LED0_PATH+"/brightness"));
				bw.write(args[0].equalsIgnoreCase("On")? "1":"0");
				bw.close();
			}
			else {
				System.out.println("Invalid command");
			}
		}
		catch(IOException e){
			System.out.println("Failed to access the Beaglebone LEDs");
		}
	}

}
