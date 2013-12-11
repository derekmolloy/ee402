// Non-Virtual Test Example
 
#include<iostream>
#include<string>
 
using namespace std;

 
class Account{
  public:
    string getType() { return "Generic Account"; };
};

class Current: public Account{
  public:
    string getType() { return "Current Account"; };  
};

class Deposit: public Account{
  public:
    string getType() { return "Deposit Account"; };  
};
 
int main()
{
  Account *a = new Account();
  Account *b = new Current();
  Account *c = new Deposit();

  cout << "Pointer a Displayed: " << a->getType() << endl;
  cout << "Pointer b Displayed: " << b->getType() << endl;
  cout << "Pointer c Displayed: " << c->getType() << endl;
}