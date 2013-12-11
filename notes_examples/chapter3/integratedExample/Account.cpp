/* Full Working Example of C++ Accounts Example used through the EE553 module
		with the addition of a static local variable
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


void main(void)
{
	Account a(1000.00);
	a.display();
	float lodgeAmount, withdrawalAmount;

	cout << "Enter amount to lodge: ";
	cin >> lodgeAmount;
	a.makeLodgement(lodgeAmount);
	a.display();

	cout << "Enter amount to withdraw: ";
	cin >> withdrawalAmount;
	if (!a.makeWithdrawal(withdrawalAmount)) cout << "Withdrawal Failed!\n";
	a.display();

	cout << "Creating a second account \n";
	Account b(30.00);
	b.display();

}