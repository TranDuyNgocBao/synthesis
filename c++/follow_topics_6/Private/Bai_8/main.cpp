#include <iostream>
#include <iomanip>
#include <math.h>
using namespace std;

int main()
{
    float a, thuong;
    cout<< "Do may nhap so a=";
    cin>> a;
    cout <<setiosflags(ios::showpoint)  << setprecision(2);
    thuong= 1/(a+1/(a+1/(a)));
    cout<<"thuong="<<thuong;
    return 0;
}
