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


/* The DepositAccount Class 

Nothing New here but used to demonstrate multiple inheritance */

class DepositAccount : public Account
{
	private:
		float interestRate;
	public:
		DepositAccount(float balance, float intRate);
		virtual void display();
		virtual void incrementInterest();
};

DepositAccount::DepositAccount(float balance, float intRate) :
	Account(balance), interestRate(intRate) {}

void DepositAccount::display()
{
	Account::display();
	// Use the display() method of Account to prevent reuse
	cout << "And has an interest rate of: " << interestRate << endl;
}

void DepositAccount::incrementInterest()
{
	balance+=(balance*interestRate/100);
}


/* The CashsaveAccount class

An account that has both an overdraft limit and an interest rate */

class CashSaveAccount : public CurrentAccount, public DepositAccount
{

	public:
		CashSaveAccount(float balance, float overdraftLimit, float intRate);
		virtual void display();
};

CashSaveAccount::CashSaveAccount(float balance, float overdraftLimit, float intRate) :
	CurrentAccount(balance, overdraftLimit), 
	DepositAccount(balance, intRate) {}

void CashSaveAccount::display()
{
	CurrentAccount::display();
	DepositAccount::display();
}



void main(void)
{
	CurrentAccount c(1000.00,5000.0);
	// Create current account object c with balance of 1000 and limit of 5000
	c.display();

	DepositAccount d(100.00, 2.5);
	d.display();
	// please note when this runs that it has a different account number than c!!

	cout << "Now for the Cashsave!! \n\n";

	CashSaveAccount cs(100.00, 5000.00, 2.5);
	cs.display();
	cs.CurrentAccount::makeLodgement(100);
	cs.display();

}
