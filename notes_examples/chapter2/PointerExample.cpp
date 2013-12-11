// Pointer Example
 
#include<iostream>
using namespace std;
 
int main()
{
   int x[5] = {1,2,3,4,5};
   int *q, *p = &x[0];
 
   //increment all values in the array by 1
   q = p;
   for (int i=0; i<5; i++)
   {
      (*q++)++;
   }

   //reset q pointer again
   q = p;
   for (int i=0; i<5; i++)
   {
     (*(q+i))++;
   }

   //do I need to reset q this time? no!

   for (int i=0; i<5; i++)
   {
	cout << "x[" << i << "] = " << x[i] <<
		" at address " << &x[i] <<
                " and the value of p is " << *(p+i) <<
		" at address " << p+i << endl;
   }
}