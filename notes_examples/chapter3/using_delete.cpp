#include <iostream>
#include <string>
using namespace std;

class bird
{
   string name;
public:
   bird();
   bird(string);
   virtual void display();
};

bird::bird(): name("No name") {}
bird::bird(string s): name(s) {}

void bird::display(){
  cout << "Name is " << name << endl;
}

int main()
{
      bird* arr = new bird[5];
      string names[5] = {"crow", "sparrow", "halk", "robin", "seagull"};

      for (int i=0; i<5; i++)
      {
          arr[i] = bird(names[i]);
      }
      for (int i=0; i<5; i++)
      {
          arr[i].display();
      }

      delete [] arr;
      return 0;
}