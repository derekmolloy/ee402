/*** Enumeration Example  - EE402 object-oriented programming
 *  ee402.eeng.dcu.ie
 */


import static java.lang.Math.*;

enum Operation 
{
	SQRT { double eval(double x) { return sqrt(x); } },
	LOG  { double eval(double x) { return log(x);  } },
	CEIL { double eval(double x) { return ceil(x); } },
	SIN  { double eval(double x) { return sin(x);  } };

	abstract double eval(double x);
}

public class EnumerationExample3
{
	public static void main(String args[]) {
		double x = Double.parseDouble(args[0]);
		for (Operation op : Operation.values()){
			System.out.printf("%s %f = %f%n", op, x, op.eval(x));
		}
	}
}
