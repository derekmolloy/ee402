/** Simple On-board LED flashing program - written by Derek Molloy
    for the ee402 module */

#include<iostream>
#include<fstream>
using namespace std;

#define LED0_PATH "/sys/class/leds/beaglebone:green:usr"

enum LED_VALUE{
     LOW=0,
     HIGH=1
};

int main(){
   std::fstream fs;
   int ledNumber = 0;
   cout << "Starting the LED flash program" << endl;

   fs.open("/sys/class/leds/beaglebone:green:usr0/trigger", 
std::fstream::out);
   fs << "none";
   fs.close();   

   cout << "Finished the LED flash program" << endl;
   return 0;
}
