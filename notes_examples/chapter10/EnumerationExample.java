/*** Enumeration Example  - EE402 object-oriented programming
 *  ee402.eeng.dcu.ie
 */

public class EnumerationExample
{
	// just for a sample
	private enum Day { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY };

	// now for this example
	private enum Drive { TURN_LEFT, TURN_RIGHT, STOP };

	public static void main(String args[]) {
		System.out.println("Enumeration Example:");
		Drive driveInstruction = Drive.STOP;
		
		switch(driveInstruction)
		{
			case TURN_LEFT:
				System.out.println("Turning left...");
				break;
			case TURN_RIGHT:
				System.out.println("Turning right...");
				break;
			case STOP:
				System.out.println("Stopping...");
				break;
			default:
				System.out.println("Invalid Instruction");
				break;
		}
		
		System.out.println("End of enumeration example.");
	}
}