/* A set of Misc. Examples using the Account Class

	Written by Derek Molloy
	Last Update 24th October 2002
*/

#include<iostream>
using namespace std;


class Account
{
	private:
		int accountNumber;
		float balance;
		int getNextAccountNumber(); // private method
		friend void someFriendPrintingFunction(Account &);
	public:
		Account(float);
		virtual void display();
		virtual void makeLodgement(float);
		virtual bool makeWithdrawal(float);
		~Account();
};


Account::Account(float newBalance)
{
	balance = newBalance;
	accountNumber = getNextAccountNumber();
}

void Account::display()
{
	cout<<"Account Details are - Account number: " << accountNumber <<
			" has balance: " << balance << endl;
}

int Account::getNextAccountNumber()
{
	static int nextAccountNumber = 1234;
	// this static value is initialised once, the first time that this method
	// is called and the value remains in memory until the programme ends. We
	// can use it to maintain the next account number for all objects of this
	// class. It only has scope within this method.
	return ++nextAccountNumber;
}

void Account::makeLodgement(float amount)
{
	balance+=amount;
}

bool Account::makeWithdrawal(float amount)
{
	if (amount>balance) return false;
	balance-=amount;
	return true;
}

Account::~Account()
{
	cout << "Destroying an Account Object! It had details as follows:\n";
	display();
	someFriendPrintingFunction( *this );
}


// Note that this function is not in Account but has access to balance and
// account number states

void someFriendPrintingFunction(Account &a)
{
	cout << "This function prints a paper record";
	cout << "Print... " << a.accountNumber << " had balance " << a.balance << endl;
}


void main(void)
{
	// Use of a pointer to display account details
	Account a(1000.00), *p;
	p = &a;
	p->display();

	// Use of new to create an anonymous object
	Account *pb = new Account(50);
	pb->display();

	pb = p; // MEMORY LEAK - code still works
	pb->display();
	// how do I access account with 50 balance? ANS: I can't!!
	// Was this account object destroyed! ANS: NO! i.e. Memory Leak.

	cout << "\nPOINT 1: About to create and destroy an account object\n";
	// Let us now test the destuctor - create a new level of scope
	{
		// new level of scope
		Account b(9000.00);
	}
	// b has just gone out of scope.
	cout << "POINT 2: The object should have been destroyed by now\n";

	cout << "\nPOINT 3:End of the program - destroy any remaining objects\n";
}