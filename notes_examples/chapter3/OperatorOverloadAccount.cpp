// Operator Overloaded Account Example
 
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

    Account operator + (Account);
    bool operator == (Account);

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

Account Account::operator + (Account a)
{
    return Account(owner, balance + a.balance, accountNumber);
}

bool Account::operator == (Account a)
{
    if ((a.balance == balance) && (a.owner == owner) && 
		(a.accountNumber == accountNumber))
    { return true; }
    else return false;
}


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

  Account c = Account("Derek Molloy", 35.50, 123457);    
  if (b == c) { cout << "b and c are equal!" << endl; }

  Account d = b + a;
  d.display();
}