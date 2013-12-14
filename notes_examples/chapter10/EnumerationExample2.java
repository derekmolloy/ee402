/*** Enumeration Example  - EE402 object-oriented programming
 *  ee402.eeng.dcu.ie
 */

enum ConversionFactor 
{
	MILESTOKILOMETRES (1.609344),
	KILOMETRESTOMILES (0.621371192),
	KILOGRAMSTOPOUNDS (2.20462262),
	POUNDSTOKILOGRAMS (0.45359237);

	private final double factor;   

	ConversionFactor(double factor) 
	{
		this.factor = factor;
	}
	public double getFactor()   { return factor; }

	public double convert(double value) 
	{
		return this.factor * value;
	}
}


public class EnumerationExample2
{
	public static void main(String args[]) {
		System.out.println("Enumeration Example:");
		double valueToConvert = Double.parseDouble(args[0]);
		for (ConversionFactor c : ConversionFactor.values())
				 System.out.printf("The Value from %s is %f%n",
				 c, c.convert(valueToConvert));
		System.out.println("End of enumeration example.");
	}
}
