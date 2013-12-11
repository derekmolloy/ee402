// Using Functions

#include<iostream>
using namespace std;
 

float addInterest(float val, float rate)
{
	return val + (val * (rate/100));
}

int main()
{
	float balance = 5000;
	float iRate = 5.0; 

	balance = addInterest(balance,iRate);
	
	cout << "After interest your balance is "
	     << balance << " Euro."<< endl;
}
