// First Template Example
// by Derek Molloy - Template Example

#include<iostream>
using namespace std;

template<class T, int size>
class Storage
{
	T values[size]; // can store 100 values of type T (basic)

public:

	T& operator [](int index)
	{
		return values[index];
	}   
};

		 
int main()
{
	Storage<int,10>   intArray;
	Storage<float,20> floatArray;

	for (int i=0; i<10; i++)
	{
		intArray[i] = i * i;
		floatArray[i] = (float)i/2.1234 ;  
	}

	for (int i=0; i<10; i++)
	{
		cout << " intArray value   = " <<   intArray[i] 
			 << " floatArray value = " << floatArray[i] << endl; 
	}
}