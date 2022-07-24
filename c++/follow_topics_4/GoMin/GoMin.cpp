#include <bits/stdc++.h>
#define
using namespace std;
int n,t,k,a[1000],best;

void input()
{
    cin>>n>>t;
    for(int i=1;i<=n;i++)
    {
        cin>>a[i];
    }
    cin>>k;
}

void update()
{
    int tmp;
    tmp=time-tui;
    if(time<=best)best=time;
}

void backtrack(int i=1)
{
    for(int j=1;j<=n;j++)
    {
        if(c[j]==0)
        {
            x[i]=j;
            c[j]=1;
            time+=abs(j-x[1]);
            if(i==1)tui=abs(j-x[1]);
            if(i==n)update();
            else if(time<=t)backtrack(i+1);
            c[j]=0;
            time-=abs(j-x[1]);
        }
    }
}

void prepare()
{
    memset(c,0,sizeof(c));
    best=oo;
}

int main()
{
    input();
    return 0;
}
