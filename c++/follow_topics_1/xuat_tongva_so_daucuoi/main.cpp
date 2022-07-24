#include <iostream>

using namespace std;

int main()
{
    int n,j,a,m;
    cin>>n;
    if(n>9999){cin>>n;}
    if(n<10){cout<<n<<" "<<"0"<<" "<<n;return 0;}
    j=0;
    a=n%10;
    do{m=n%10;
       j=j+m;
       n=n/10;}while(n!=0);
    cout<<j<<" "<<m<<" "<<a;
    return 0;
}
