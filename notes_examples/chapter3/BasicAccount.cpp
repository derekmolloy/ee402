 
#include<iostream>
 
using namespace std;
 
class Account{

    int accountNumber;
    float balance;

  public:

    virtual void display();
    virtual void makeLodgement(float);
    virtual void makeWithdrawal(float);
};

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
  Account a;
  a.display();  //will output rubbish for the stages
}