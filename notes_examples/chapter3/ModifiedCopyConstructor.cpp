// Example of a Modified Copy Constructor
 
#include<iostream>
#include<string>
 
using namespace std;
 
class Account{

  protected:

    int accountNumber;
    float balance;
    string owner;

  public:

    Account(string owner, float aBalance, int anAccountNumber);
    Account(float aBalance, int anAccountNumber);
    Account(int anAccountNumber);
    Account(const Account &sourceAccount);

    virtual void display();
    virtual void makeLodgement(float);
    virtual void makeWithdrawal(float);
};

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
 

int main()
{
    Account a = Account("Derek Molloy",35.00,34234324); 
    Account b(a);
    
    a.display();
    b.display();   

    a.makeLodgement(100.0);

    a.display();   
    b.display();    
}