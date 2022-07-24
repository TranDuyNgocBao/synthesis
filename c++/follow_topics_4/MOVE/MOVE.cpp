#include <bits/stdc++.h>

using namespace std;
const long long o=-2000000;
long long a[1005][1005],f[2005][2005],res=o;

int main()
{
    freopen("MOVE.INP","r",stdin);
    freopen("MOVE.OUT","w",stdout);
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n,m;
    cin>>m>>n;
    for(int i=2;i<=m+1;i++)
    {
        for(int j=2;j<=n+1;j++)cin>>a[i][j];
    }
    for(int i=2;i<=m;i++)
    {
        for(int j=0;j<=n+3;j++)
        {
            f[i][j]=o;
        }
    }
    for(int i=2;i<=m+1;i++)
    {
        for(int j=2;j<=n+1;j++)
        {
            f[i][j]=a[i][j]+max(max(max(max(f[i-1][j-2],f[i-1][j-1]),f[i-1][j]),f[i-1][j+1]),f[i-1][j+2]);
        }
    }
    for(int i=2;i<=n+1;i++)
    {
        res=max(f[m+1][i],res);
    }
    cout<<res;
    return 0;
}
