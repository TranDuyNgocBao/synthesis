#include <bits/stdc++.h>

using namespace std;

int pow10(long long int t)
{
    long long int i,xl=1;
    for(i=1;i<=t;i++)
    {
        xl=xl*10;
    }
    return xl;
}

int main()
{
    long long int k,n,m,i,s=1;
    cin>>k>>m>>n;
    for(i=1;i<=n;i++)
    {
        s=((s%pow10(k))*(m%pow10(k)))%pow10(k);
    }
    if(s<10)cout<<"0";
    cout<<s;
    return 0;
}
