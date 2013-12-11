// Using Functions (with Pass by reference)

#include<iostream>
using namespace std;
 
void addInterest(float &val, float rate)
{
 	val = val + (val * (rate/100));
}

int main()
{
	float balance = 5000;
	float iRate = 5.0; 

	addInterest(balance,iRate);
	
	cout << "After interest your balance is "
		<< balance << " Euro."<< endl;
}
