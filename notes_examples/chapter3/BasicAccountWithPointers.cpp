// Basic Bank Account Example with Constructors
 
#include<iostream>
 
using namespace std;
 
class Account{

    int accountNumber;
    float balance;

  public:

    Account(float aBalance, int anAccountNumber);
    virtual void display();
    virtual void makeLodgement(float);
    virtual void makeWithdrawal(float);
};

Account::Account(float aBalance, int anAccNumber)
{
	accountNumber = anAccNumber;
	balance = aBalance;
}

void Account::display(){
    cout << "account number: " << accountNumber
      << " has balance: " << balance << " Euro" << endl;
}

void Account::makeLodgement(float amount){
    balance = balance + amount;
}

void Account::makeWithdrawal(float amount){
    balance = balance - amount;
}


int main()
{
  Account anAccount = Account(35.00,34234324); 
  anAccount.makeLodgement(20.0);
  anAccount.display();

  Account testAccount = Account(5.0, 12345);
  Account *testPtr = &testAccount;
  testPtr->makeLodgement(20.0);
  testPtr->display(); 
}