#include <bits/stdc++.h>
#define Max 1000000
using namespace std;
long int n,m,t,timese;
long int adj[Max],d[Max],f[Max],head[Max];

void input()
{
    long int j=0;
    cin>>n>>t;
    for(long int i=1;i<=n;i++)
    {
        long int v;
        do
        {
            cin>>v;
            if(v!=0)
            {
                j++;
                adj[j]=v;
            }
        }while(v!=0);
        head[i]=j;
    }
    head[0]=0;
    memset(d,1,sizeof(d));
}

void DFSVisit(long int u)
{
    timese+=1;
    d[u]=timese;
    cout<<u<<" ";
    for(long int i=head[u-1]+1;i<=head[u];i++)
    {
        if(d[adj[i]]==0)DFSVisit(adj[i]);
    }
    timese+=1;
    f[u]=timese;
}

int main()
{
    input();
    for(long int i=1;i<=n;i++)d[i]=0;
    timese=0;
    for(long int i=t;i<=n;i++)
    {
        if(d[i]==0)DFSVisit(i);
    }
    cout<<endl;
    for(long int i=1;i<=n;i++)
    {
        cout<<f[i]<<' ';
    }
    return 0;
}
