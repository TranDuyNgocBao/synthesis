#include <iostream>

using namespace std;

int main()
{
    int a,b,i=0;
    cin>>a>>b;
    while(2*a<=b){ a=2*a; i++; }
    cout<<i--;
    return 0;
}
