// Size of Variables

#include<iostream.h>
 
int main()
{
	float a = 25.0;   
	int b = 545;
	double c = 123.0;
	char d = 'A';
	bool e = true;

	std::cout << "a has value " << a << " and size " << sizeof(a) << " bytes\n"; //4
	cout << "b has value " << b << " and size " << sizeof(b) << " bytes\n"; //4
	cout << "c has value " << c << " and size " << sizeof(c) << " bytes\n"; //8
	cout << "d has value " << d << " and size " << sizeof(d) << " bytes\n"; //1
	cout << "e has value " << e << " and size " << sizeof(e) << " bytes\n"; //1
}
