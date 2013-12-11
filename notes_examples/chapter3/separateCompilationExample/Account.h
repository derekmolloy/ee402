// Example of Separate Compilation with the Account Class

#include<iostream>
#include<string>

using std::string;  

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