#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n,i,x;
    cin>>n;int a[n+3];
    for(i=1;i<=n;i++){cin>>a[i];}
    cin>>x;
    for(i=1;i<=n;i++)
    {
        if(a[i]==x)cout<<"True";return 0;
    }
    if(i>n)cout<<"No";
}
