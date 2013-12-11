#include<string>
#include"A.h"
using std::string;

class AA;

class B: public A{

  AA *a;

  public:
     B(string);

};
