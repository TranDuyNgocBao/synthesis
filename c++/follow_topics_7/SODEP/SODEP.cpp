#include <bits/stdc++.h>

using namespace std;

#define maxn 6002
#define FOR(i,l,r)for(int i=l; i<=r; ++i)

int n, a[maxn], cnt;
bool check[maxn];
unordered_map<int,int>maxPos;

int main()
{
    ios::sync_with_stdio(0); cin.tie(0);
    freopen("SODEP.INP","r",stdin);
    freopen("SODEP.OUT","w",stdout);
    cin>>n;
    FOR(i,1,n)cin>>a[i];
    FOR(i,1,n-2) FOR(j,i+1,n-1) FOR(k , j+1, n)
        maxPos[a[i]+a[j]+a[k]]=max(a[i]+a[j]+a[k], i);
    FOR(i, 1, n)
        check[i]=maxPos[a[i]]>i;
    FOR(i, 1, n)
        cnt+=check[i];
    cout<<cnt;
    return 0;
}





/*#include<bits/stdc++.h>
#define maxn 5002
#define FOR(i,l,r)for(int i=l; i<=r; i++)
#define FORn(i,l,r)for(int i=l; i>=r; i--)

using namespace std;
const long int o=-923483294839;
long int n, a[maxn], b[maxn], dem;
long int y=o;

int main()
{
    ios::sync_with_stdio(0); cin.tie(0);
    freopen("SODEP.INP","r",stdin);
    //freopen("SODEP.OUT","w",stdout);
    cin>>n;
    FORn(i,n,1)
    {
        cin>>a[i];
        b[i]=a[i];
    }
    sort(b+1,b+n+1);
    if(n<=3){cout<<0; return 0;}
    if(b[n]==0){cout<<1; return 0;}
    FOR(i,1,n)
    {
        if(b[i]==b[i+1])continue;
        if(b[i]==y)continue;
        FOR(j,1,n-3)
        {
            FOR(u,j+1,n-2)
            {
                FOR(k,u+1,n-1)
                {
                    if(a[j]+a[u]+a[k]==b[i]){y=b[i];dem++;break;}
                }
                if(y==b[i])break;
            }
            if(y==b[i])break;
        }
    }
    cout<<dem;
}*/

