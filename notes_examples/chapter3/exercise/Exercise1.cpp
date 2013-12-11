
#include <iostream.h>
#include <string.h>

using namespace std;

class Person
{
   private:
	string name;
	string address;
	string telephone;

   public:
	Person(string, string, string);

	virtual void display();
	virtual void setAddress(string);
	virtual void setTelephone(string);	
};


Person::Person(string aName, string anAddress, string aTelephone):
	name(aName), address(anAddress), telephone(aTelephone) {}

void Person::display()
{
	cout << "Name: " << name << endl;
	cout << "Address: " << address << endl;
	cout << "Telephone: " << telephone << endl;
}

void Person::setAddress(string newAddress)
{
	address = newAddress;
}

void Person::setTelephone(string newTelephone)
{
	telephone = newTelephone;
}

void main(void)
{
	Person a("Derek Molloy", "DCU, Glasnevin, D9", "7005355");
	a.display();

	cout << endl << "Setting Telephone Number" << endl << endl;

	a.setTelephone("01-7005355");
	a.display();
}