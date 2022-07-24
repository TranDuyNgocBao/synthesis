#include <bits/stdc++.h>

using namespace std;
long long v,s;

int main()
{
    freopen("BAI2L1018.INP","r",stdin);
    freopen("BAI2L1018.OUT","w",stdout);
    int n;
    cin>>n;
    for(int i=1; i<=n;i++)
    {
        cin>>v;
        if(v%3==0)s+=v;
    }
    cout<<s;
    return 0;
}
