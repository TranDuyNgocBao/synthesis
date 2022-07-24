#include <bits/stdc++.h>
using namespace std;
float a[10005][10005];
int i, j, n, m, s, t, x[100005],y[100005], d[100005];
int main()
{ ios::sync_with_stdio(0); cin.tie(0);
 //freopen( "TIMDUONG.INP" , "r", stdin);
// freopen( "TIMDUONG.OUT" , "w", stdout);
    cin >> n >> m >> s>> t;
 for (i=1; i<=n; ++i)
    cin >> x[i] >> y[i];
    for (i=1; i<=n; ++i)
    for (j=1; j<=n; ++j)
    { if (i==j)  { a[i][j]=-1; continue;}
        float tmp = sqrt( (x[i]-x[j])*(x[i]-x[j]) + (y[i]-y[j])*(y[i]-y[j]) );
        a[i][j] = tmp;
        }
    queue <int> ds;
    ds.push(s);
memset(d, 0, sizeof(d));
    while(!ds.empty())
    { int u= ds.front(); ds.pop();
        for (i=1; i<=n; ++i)
            if ((d[i]==0)&&(a[u][i]!=-1)&&(a[u][i]<=m))
        {  d[i] = d[u] +1;
           ds.push(i);}
    }
 cout<<d[t]-1;
    return 0;
}
