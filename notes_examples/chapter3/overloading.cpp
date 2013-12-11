// Over-Loaded Methods
 
#include<iostream.h>
#include<string.h>
 
using namespace std;
 
class myMaths
{
   public:
     virtual int add(int a, int b);
     virtual float add(float a, float b);
     virtual string add(string a, string b);
};

int myMaths::add(int a, int b) 
{
  return (a+b);
}
 
float myMaths::add(float a, float b) {
  return (a+b);
}
 
string myMaths::add(string a, string b) 
{
  return (a+b);
}

main() {
	myMaths m;

	cout << "1 + 2 = " << m.add(1,2) << endl;
	cout << "1.5 + 2.0 = " << m.add(1.5f,2.0f) << endl;
	cout << "one + two = " << m.add("one","two") << endl;
}