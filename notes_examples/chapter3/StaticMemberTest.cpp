// Static Member Example
 
#include<iostream>
#include<string>
 
using namespace std;

 
class Account{

  protected:

    static int nextAccountNumber;
    int accountNumber;
    float balance;
    string owner;

  private:

    void construct();

  public:

    Account(string owner, float aBalance);
    Account(float aBalance);

    virtual void display();
    virtual void makeLodgement(float);
    virtual void makeWithdrawal(float);
};

int Account::nextAccountNumber = 123456;

Account::Account(string anOwner, float aBalance):
	balance(aBalance),
	owner (anOwner) { construct(); }

Account::Account(float aBalance) :
	balance(aBalance),
	owner ("Not Defined") { construct(); }

void Account::construct()
{
   accountNumber = nextAccountNumber++;
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
  Account *a = new Account("John", 10.50);
  Account *b = new Account("Derek", 12.70);

  a->display();
  b->display();
}