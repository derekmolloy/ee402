// String Example

#include<iostream>
#include<string>


int main()
{
	// create new string variables
	std::string s = "hello ";
	std::string t = "world!";

	// modify the strings directly, replace h with H
	s[0] = 'H';

	// compare strings
	if (t == "world!") 
	{
	  t = "World!";	//note capital W
	}

	std::string u = s + t;

	// will output "Hello World!"
	std::cout << u << std::endl;
	std::cout << "This string is " << u.length() 
	     << " characters long." << std::endl;
}
