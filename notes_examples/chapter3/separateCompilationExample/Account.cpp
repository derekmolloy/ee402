// Example of a Modified Copy Constructor
 
#include "Account.h"
 
using namespace std;

Account::Account(string anOwner, float aBalance, int anAccNumber):
	accountNumber(anAccNumber), balance(aBalance),
	owner (anOwner) {}

Account::Account(float aBalance, int anAccNumber) :
	accountNumber(anAccNumber), balance(aBalance),
	owner ("Not Defined") {}

Account::Account(int anAccNumber):
	accountNumber(anAccNumber), balance(0.0f),
	owner ("Not Defined") {}

Account::Account(const Account &sourceAccount):
	accountNumber(sourceAccount.accountNumber + 1), 
	balance(0.0f),
	owner (sourceAccount.owner) {}


void Account::display(){;
    cout << "account number: " << accountNumber
      << " has balance: " << balance << " Euro" << endl;
    cout << "This account is owned by: " << owner << endl;
}

void Account::makeLodgement(float amount){
    balance = balance + amount;
}

void Account::makeWithdrawal(float amount){
    balance = balance - amount;
}
 

 