#include <iostream>

using namespace std;

int main()
{
    int i,a[4],b,c,d,j;
    for(i=0;i<4;i++){cin>>a[i];}
    j=0;
    for(b=0;b<4;b++){j=j+a[b];}
    if(j<10){cout<<j<<" "<<"0"<<" "<<j;return 0;}
    else c=j%10;
         d=j/10;
         d=d%10;
    cout<<j<<" "<<d<<" "<<c;
    return 0;
}
