/* Full Working Example of C++ Accounts Example used through the EE553 module
		with the addition of the the CurrentAccount
	Written by Derek Molloy
	Last Update 24th October 2002
*/

#include<iostream>
using namespace std;


class Account
{
	private:
		int accountNumber;
		int getNextAccountNumber(); // private method

	protected:
		float balance; // had to modify balance access for current account makeWithdrawal
					   // could also have written a getBalance, setBalance method (probably better!)
	public:
		Account(float);
		virtual void display();
		virtual void makeLodgement(float);
		virtual bool makeWithdrawal(float);
		virtual ~Account();
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
	cout<<" Destroying Account Object!" << endl;
}


/*  The CurrentAccount Class

We will add the CurrentAccount Class which is a child or derived class
of the Account class. This class will use the makeLodgement method of 
Account but the display and makeWithdrawal methods are no longer suitable */

class CurrentAccount : public Account
{
	private:
		float overdraftLimit;
	public:
		CurrentAccount(float balance, float limit);
		virtual void display();
		virtual bool makeWithdrawal(float);
		virtual ~CurrentAccount();
};


CurrentAccount::CurrentAccount(float balance, float limit) :
	Account(balance), overdraftLimit(limit) {}
// Have to use member initialisation list to construct parent


void CurrentAccount::display()
{
	Account::display();
	// Use the display() method of Account to prevent reuse
	cout << "And has overdraft limit: " << overdraftLimit << endl;
}

bool CurrentAccount::makeWithdrawal(float amount)
{
	if (amount>(balance+overdraftLimit)) return false;
	// need protected access to balance to alter it.
	balance-=amount;
	return true;
}

CurrentAccount::~CurrentAccount()
{
	cout<<" Destroying CurrentAccount Object!" << endl;
}


void main(void)
{
	CurrentAccount c(1000.00,5000.0);
	// Create current account object c with balance of 1000 and limit of 5000
	c.display();
	float lodgeAmount, withdrawalAmount;

	Account *ActArray[10];
	ActArray[0] = &c;
	ActArray[0]->display();
	ActArray[1] = new Account(300);
	ActArray[1]->display();
	ActArray[2] = new CurrentAccount(1000, 500);
	ActArray[2]->display();
	delete ActArray[1];
	delete ActArray[2];

	cout << "end of program\n";

}