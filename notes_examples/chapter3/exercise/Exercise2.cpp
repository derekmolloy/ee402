
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

	void display();
	void setAddress(string);
	void setTelephone(string);	
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



class Staff: public Person
{
   private:
	string office;
	double salary;
	string staffID;

   public:
	Staff(Person p, string anOffice, string aStaffID, double aSalary);

	virtual void display();
	virtual void setOffice(string anOffice);
	virtual void addPayRise(double percentageIncrement);
};

Staff::Staff(Person p, string anOffice, string aStaffID, double aSalary):
	Person(p), office(anOffice),
	staffID(aStaffID), salary(aSalary) {}

void Staff::display()
{
	Person::display();
	cout << "Office: " << office << endl;
	cout << "ID Number: " << staffID << endl;
	cout << "Salary: " << salary << " Euro" << endl;
}

void Staff::setOffice(string anOffice) 
{
	office = anOffice;
}

void Staff::addPayRise(double percentageIncrement)
{
	salary+=(salary*percentageIncrement/100);
}


void main(void)
{
	Person a("Derek Molloy", "DCU, Glasnevin, D9", "7005355");
	a.display();

	cout << endl << "Creating Staff Member:" << endl << endl;

	Staff b(a, "S356", "94971056", 12000);
	b.display();

	cout << endl << "Payrise of 5%:" << endl << endl;

	b.addPayRise(5.0);
	b.display();
}