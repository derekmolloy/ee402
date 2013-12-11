// Example of a Separate Compilation 
 
#include "Account.h"

void main()
{
    Account a = Account("Derek Molloy",35.00,34234324); 
    Account b(a);
    
    a.display();
    b.display();   

    a.makeLodgement(100.0);

    a.display();   
    b.display();    
}