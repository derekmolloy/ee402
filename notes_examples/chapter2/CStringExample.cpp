// CString Example

#include<iostream>
#include<cstring>

int main()
{
    char s[20] = "hello ";
    char t[] = { 'w', 'o', 'r', 'l', 'd', '!', '\0' };

    // modify the strings directly, replace h with H
    s[0] = 'H';

    // compare strings
    if (strcmp(t, "world!") == 0)
    {
      strcpy(t, "World!");   //note capital W
    }

    char *u = strcat (s, t);

    // will output "Hello World!"
    std::cout << u << std::endl;
    std::cout << "This string is " << strlen(u)
	     << " characters long." << std::endl;
}
