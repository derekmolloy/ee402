/* Separate Compilation Example with Circular references
*
*
*		I would use (I am assuming that string is required in the definition of
*		all classes, e.g. a string is a parameter to the constructor of all
*		classes.
*
*		Base Class
*		A.h:
*		#include<string>
*		using std::string;
*		A.cpp:
*		#include "A.h"
*		#include<iostream> (if required for cout etc.)
*		using namespace std;   (if required)
*
*		Child Class
*		AA.h:
*		#include "A.h"
*		#include "B.h"   (as B is a-part-of AA from your diagram e.g. B is a
*		state)
*		AA.cpp:
*		#include "AA.h"
*		#include<iostream> (if required for cout etc.)
*		using namespace std;   (if required)
*
*		Part-of Class
*		B.h:
*		#include<string>
*		using std::string;
*		B.cpp:
*		#include "A.h"
*		#include<iostream> (if required for cout etc.)
*		using namespace std;   (if required)
*
*		Application.cpp:
*		#include<iostream>
*		#include "AA.h"   (allows object of AA to be created that uses A and B)
*		using namespace std;
*
*
*		Now, if B needs to know about AA (a circular AA->B B->AA reference) then
*		you must add:
*		 
*		class AA;
*
*		to the B.h header, just before you define your class B. This tells the
*		compiler that AA is a class that it will see later on!
*
*		Now, if B was also a child of A (adding #include "A.h" to B.h), you
*		would have to add #ifndef around the A definition in A.h to prevent
*		double definition of the class A. I have attached this, the most
*		complicated case to this e-mail as an example. In this example:
*
*		A is the parent of AA and B
*		AA is a child of A and B is a part-of AA
*		B is a child of A and AA is a part-of B
*		I have added the minimum namespace usage necessary in the header file.
*
*							A
*
*						  /    \
*
*		(has part-of B) AA      B (has part-of AA)
*
*/

#include <iostream>
#include "AA.h"
using namespace std;

int main(int argc, char *argv[])
{
  AA("Test application");
  return 0;
}
