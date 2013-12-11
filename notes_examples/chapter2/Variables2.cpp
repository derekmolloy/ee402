// Using variables with automatic conversion

#include<iostream.h>

int main()
{
  int x,y;
  
  x = 6.23;      // x becomes 6
  cout << "x = " << x << "\n";

  char c = 'w';  // (see <co id="varinit-co" linkends="varinit" /> )
  cout << "c = " << c << "\n";

  x = c;        // x becomes the integer
                // equivalent of ‘w’ which is 119
  cout << "x = " << x << "\n";

  y = 2.110;    // y becomes 2
  double d;     // (see <co id="varintro-co" linkends="varintro" />)
  d = y;        // d becomes 2.0
  cout << "d = " << d << "\n";
 
  const float pi = 3.14159;
                // (see <co id="varconst-co" linkends="varconst" />)
//pi = 223.34;  // would be an error
}