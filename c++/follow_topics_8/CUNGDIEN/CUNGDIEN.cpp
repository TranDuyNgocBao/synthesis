#include <bits/stdc++.h>

using namespace std;
vector<long int>x(20), y(20);
long int a[1000][1000];
long int n,ch[1000],cp[1000],cot[1000],Minn=0;

void Finding_MIN()
{
    long int i,j;
    for(i=1;i<=n;i++)
    {
        for(j=1;j<=n;j++)
        {
            Minn+=a[i][j];
        }
    }
}

void input()
{
    cin>>n;
    long int i,j;
    for(i=1;i<=n;i++)
    {
        for(j=1;j<=n;j++)
        {
            cin>>a[i][j];
        }
    }
}

void sumtester()
{
    long int i,S=0;
    for(i=1;i<=n;i++)
    {
        S+=a[i][x[i]];
    }
    if(S<=Minn)
    {
        Minn=S;
        for(i=1;i<=n;i++)
        {
            y[i]=x[i];
        }
    }
}

void Backtrack(long int k=1)
{
    for(long int i=1;i<=n;i++)
    {
        long int u,t;
        u=k+i;
        t=k-i+n;
        if((cot[i]==0)&&(cp[u]==0)&&(ch[t]==0))
        {
            x[k]=i;
            cot[i]=1;
            ch[t]=1;
            cp[u]=1;
            if(k==n)sumtester();
            else Backtrack(k+1);
            cot[i]=0;
            ch[t]=0;
            cp[u]=0;
        }
    }
}

void output()
{
    cout<<Minn<<endl;
    for(long int i=1;i<=n;i++)cout<<y[i]<<" ";
}

int main()
{
    input();
    Finding_MIN();
    memset(cot,0,sizeof(cot));
    memset(ch,0,sizeof(ch));
    memset(cp,0,sizeof(cp));
    Backtrack();
    output();
    return 0;
}
