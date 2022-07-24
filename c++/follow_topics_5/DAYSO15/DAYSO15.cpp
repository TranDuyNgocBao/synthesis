#include <bits/stdc++.h>

using namespace std;

int main()
{
    freopen("DAYSO15.INP","r",stdin);
    freopen("DAYSO15.OUT","w",stdout);
    long n,m;
    cin>>n>>m;
    long a[n+2],b[n+2];
    long i,j,maxx=0,bs;
    for(i=0;i<n;i++){cin>>a[i];}
    for(j=0;j<m;j++){cin>>b[j];}
    sort(a,a+n);
    for(j=0;j<m;j++)
    {
        long dem=0;
        for(i=0;i<n;i++)
        {
            if(a[i]==b[j]){dem=dem+1;}
            if((a[i+1]!=b[j])&&(a[i]==b[j]))break;
        }
        if(dem>maxx){maxx=dem;bs=b[j];}
    }
    cout<<bs<<" "<<maxx;
    return 0;
}

