#include <bits/stdc++.h>
#define Max 100000
using namespace std;
long int n,m,t;
long int adj[Max],head[Max],avail[Max],trace[Max];

void input()
{
    long int j=0,v;
    cin >> n >> m >> t;
    for(long int i=1;i<=n;i++)
    {
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
    memset(avail,0,sizeof(avail));
}

void DFSVisit(long int u)
{
    avail[u]=1;
    cout<<u<<" ";
    for(long int i=head[u-1]+1;i<=head[u];i++)
    {
        if(avail[adj[i]]==0)
        {
            trace[adj[i]]=u;
            DFSVisit(adj[i]);
        }
    }
}

void Print()
{
    if(avail[t]==0)
    {
        cout<<"No Path";
    }
    else
    {
        cout<<"The Path : ";
        long int out[Max],j=1;;
        while(t!=m)
        {
            out[j]=t;
            t=trace[t];
            j++;
        }
        cout<<m<<" ";
        for(long int i=j-1;i>=1;i--)cout<<out[i]<<" ";
    }
}

int main()
{
    input();
    DFSVisit(m);
    cout<<endl;
    Print();
    return 0;
}


