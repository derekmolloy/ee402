// Dynamic Creation of Objects Example
 
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
    cout << "Account number: " << accountNumber
      << " has balance: " << balance << " Euro" << endl;
    cout << "  This account is owned by: " << owner << endl;
}

void Account::makeLodgement(float amount){
    balance = balance + amount;
}

void Account::makeWithdrawal(float amount){
    balance = balance - amount;
}
 

int main()
{
  Account someAccounts[3] = {
        Account("Tom", 20.00, 123456),
        Account("Richard", 55.00, 123457),
        Account("Harry", 99.00, 123458) };
  Account *p = &someAccounts[0];

  someAccounts[2].display();    //displays Harry

  p->display();		//displays Tom
  (++p)->display();     //displays Richard
  (p+1)->display();     //displays Harry
	
  //Warning! The pointer p now points at Richard, not Tom!
}