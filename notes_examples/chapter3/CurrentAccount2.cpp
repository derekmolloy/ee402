// Basic Bank Account Example with Constructors
 
#include<iostream>
 
using namespace std;
 
class Account{

  protected:

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

class CurrentAccount: public Account
{
      float overdraftLimit;

  public:
      
      CurrentAccount(float balance, int accountNumber, float limit);
      virtual void setOverDraftLimit(float newLimit);
      virtual void display();
      virtual void makeWithdrawal(float amount);
};

CurrentAccount::CurrentAccount( float balance, int accountNumber, float limit):
      Account(balance, accountNumber), overdraftLimit(limit) 
{}

void CurrentAccount::display()
{
    cout << "Account number: " << accountNumber
      << " has balance: " << balance << " Euro" << endl;
    cout << "  And overdraft limit: " << overdraftLimit << endl;
}

void CurrentAccount::makeWithdrawal(float amount)
{
    if (amount < (balance + overdraftLimit)) 
    {
	balance = balance - amount;
    }
}

void CurrentAccount::setOverDraftLimit(float limit)
{
    overdraftLimit = limit;
}

int main()
{
  Account a = Account(35.00,34234324); 
  Account *ptrA = &a;

  CurrentAccount b = CurrentAccount(50.0, 12345, 200.0);
  CurrentAccount *ptrB = &b;

  cout << "Displaying ptrA:" << endl;
  ptrA->display();
  cout << "Displaying ptrB:" << endl;
  ptrB->display();
  
  //ptrB = ptrA;   // not allowed

  ptrA = ptrB;
  cout << "Displaying ptrA again:" << endl;
  ptrA->display();  
}