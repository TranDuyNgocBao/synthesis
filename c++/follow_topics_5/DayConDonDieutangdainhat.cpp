#include <bits/stdc++.h>
#define maxx 1000
using namespace std;

int main()
{
    long long int a[maxx+1],b[maxx+1],L[maxx+1],T[maxx+1];
    long long int n,i,j,jmax;
    cin>>n;
    for(i=1;i<=n;i++)
    {
        cin>>a[i];
        b[i]=a[i];
    }
    sort(b+1,b+n+1);
    a[0]=b[1]-1;
    a[n+1]=b[n]+1;
    L[n+1]=1;
    for(i=n;i>=0;i--)
    {
        jmax=n+1;
        for(j=i+1;j<=n+1;j++)
        {
            if((a[j]>a[i])&&(L[j]>L[jmax]))jmax=j;
        }
        L[i]=L[jmax]+1;
        T[i]=jmax;
    }
    cout<<L[0]-2<<endl;
    i=T[0];
    while(i!=n+1)
    {
        cout<<a[i]<<' ';
        i=T[i];
    }
    return 0;
}
