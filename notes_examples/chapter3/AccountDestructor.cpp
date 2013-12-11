// Basic Bank Account Example demonstrating abstract classes
 
#include<iostream>
#include<string>
 
using namespace std;
 
class Account{

  protected:

    int accountNumber;
    float balance;

  public:

    Account(float aBalance, int anAccountNumber);
    virtual ~Account();
    virtual string getAccountType() = 0;
    virtual void display();
    virtual void makeLodgement(float);
    virtual void makeWithdrawal(float);
};

Account::Account(float aBalance, int anAccNumber)
{
	accountNumber = anAccNumber;
	balance = aBalance;
}

Account::~Account()
{
   cout << "Account object being destroyed!" << endl;
}

void Account::display(){
    cout << "Account type: " << getAccountType() << endl;
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
      virtual ~CurrentAccount();
      virtual string getAccountType() { return "Current Account"; }
      virtual void setOverDraftLimit(float newLimit);
      virtual void display();
      virtual void makeWithdrawal(float amount);
};

CurrentAccount::CurrentAccount( float balance, int accountNumber, float limit):
      Account(balance, accountNumber), overdraftLimit(limit) 
{}

CurrentAccount::~CurrentAccount()
{
   cout << "Current Account object being destroyed!" << endl;
}

void CurrentAccount::display()
{
    Account::display();
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
  //ccount a = Account(35.00,34234324);    NOT ALLOWED
  //Account *ptrA = &a;

  CurrentAccount b = CurrentAccount(50.0, 12345, 200.0);
  b.display();

}