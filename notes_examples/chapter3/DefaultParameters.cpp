// Default Parameters
 
#include<iostream>
using namespace std;
 
void decrement(int &aValue, int amount = 1)
{
  aValue = aValue - amount;
} 

int main()
{

  int x = 10;
  decrement(x,3);  // x now has the value 7
  cout << "x now has the value: " << x << endl;
  decrement(x);	// x now has the value 6
  cout << "x now has the value: " << x << endl;
}