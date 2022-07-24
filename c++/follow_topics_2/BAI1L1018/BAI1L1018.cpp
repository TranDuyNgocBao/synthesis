#include <bits/stdc++.h>

using namespace std;

int main()
{
    freopen("BAI1L1018.INP","r",stdin);
    freopen("BAI1L1018.OUT","w",stdout);
    long int a,b,c=0;
    for(int i=1;i<=2;i++)
    {
        cin>>a>>b;
        c=max(c,a*b);
    }
    cout<<c;
    return 0;
}
