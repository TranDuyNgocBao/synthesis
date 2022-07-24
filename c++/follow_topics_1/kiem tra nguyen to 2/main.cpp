#include <bits/stdc++.h>

using namespace std;

int KTNT(int x)
{
    int i,kt=1;
    if(x==1)kt=0;
    for(i=2;i<=sqrt(x);i++)
    {
        if(x%i==0){kt=0;break;}
    }
    return kt;
}

int main()

{
    int xd;
    unsigned int a;
    cin>>a;
    xd=KTNT(a);
    if(xd==0)cout<<-1;
    else cout<<a<<" nguyen to.";
    return 0;
}
