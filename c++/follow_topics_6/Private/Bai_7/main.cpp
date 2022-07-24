#include <iostream>
#include <iomanip>
#include <math.h>
using namespace std;

int main()
{
    float a,b,c;
    cout<< setiosflags(ios::showpoint)<< setprecision(3);
    cout<<"a,b,c=";
    cin>>a>>b>>c;
    cout << a<<"x^2+"<<b<<"x+"<<c;

    return 0;
}
