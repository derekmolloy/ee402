// Basic Bank Account Example demonstrating multiple constructors
 
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
  Account a = Account(10.50, 123456);  
  a.display();

  Account b = Account("Derek Molloy", 35.50, 123457);  
  b.display();
}