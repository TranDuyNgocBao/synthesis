#include <bits/stdc++.h>

using namespace std;

int main()
{
    long long i,n,a[5002],f[10000];
    cin>>n;
    for(i=1;i<=n;i++)cin>>a[i];
    f[0]=0;
    f[1]=a[1];
    f[2]=a[1]+a[2];
    for(i=3;i<=n;i++)
    {
        f[i]=max(max(f[i-2]+a[i],f[i-1]),f[i-3]+a[i-1]+a[i]);
    }
    cout<<f[n];
    return 0;
}
