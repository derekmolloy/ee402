

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

class Fish
{
	string name;
public:
	Fish(string);
	virtual void display();
};

Fish::Fish(string nm): name(nm) {}

void Fish::display()
{
	cout << "I am a fish and my name is " << name << endl;
}

void outputFunction(Fish x)
{       
	x.display();
}
 
int main(void)
{
      string x;                                                                               
      vector<Fish> vect;  // declare a vector container of Fish
                                                              
      cout << "Please enter five Fish:" << endl;      
      for(int i=0; i<5; i++)                 
      {
	cin >> x;
      	vect.push_back(Fish(x)); 
      }
             
      // loop through vector with for_each loop and execute 
      // outputFunction() for each element       
      
      for_each(vect.begin(), vect.end(), outputFunction);
}