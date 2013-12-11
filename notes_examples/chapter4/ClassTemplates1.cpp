// First Template Example
// by Derek Molloy - Template Example

#include<iostream>
using namespace std;

template<class T>
class Storage
{
	T values[100]; // can store 100 values of type T (basic)

public:

	T& operator [](int index)
	{
		return values[index];
	}   
};

		 
int main()
{
	Storage<int>   intArray;
	Storage<float> floatArray;

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