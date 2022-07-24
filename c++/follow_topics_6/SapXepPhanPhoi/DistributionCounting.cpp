#include <bits/stdc++.h>

using namespace std;

int main()
{
    long int a[100000],c[100000],n,i,k;
    cin>>n>>k; //K la gia tri lon nhat cua day
    for(i=1;i<=n;i++)cin>>a[i];
    for(i=0;i<=k;i++)c[i]=0;
    for(i=1;i<=n;i++)c[a[i]]=c[a[i]]+1;
    for(i=0;i<=k;i++)
    {
        while(c[i]!=0)
        {
            cout<<i<<" ";
            c[i]-=1;
        }
    }
    return 0;
}
