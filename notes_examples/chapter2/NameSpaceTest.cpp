 
#include<iostream>

namespace TestNameSpace
{
	float testAdd(float a, float b) { return a+b; }
	
	class Time
	{
      public:
    }
          
}

using std::cout;
using std::endl;
using namespace MolloySpace; 

class Account{

    int accountNumber;
    float balance;

  public:
	Account();
    virtual void display();
    virtual void makeLodgement(float);
    virtual void makeWithdrawal(float);
};

Account::Account()
{
	accountNumber = 1234;
	balance = 0.0;
}

void Account::display(){
    cout << "account number: " << accountNumber
      << " has balance: " << balance << " Euro" << endl;
}

void Account::makeLodgement(float amount){
    balance = testAdd(balance, amount);
}

void Account::makeWithdrawal(float amount){
    balance = testAdd(balance, -amount);
}


int main()
{
  Account a;
  a.makeLodgement(200.0);
  a.display();  
}