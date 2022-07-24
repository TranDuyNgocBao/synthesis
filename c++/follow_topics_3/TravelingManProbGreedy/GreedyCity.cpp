#include <bits/stdc++.h>
#define oo 1000000
using namespace std;
vector <int>x(50);
int d[50];
int n,a[22][22],sum=0;

void input()
{
    int i,j;
    cin>>n;
    for(i=1;i<=n;i++)
    {
        for(j=1;j<=n;j++)
            cin>>a[i][j];
    }
}

void output()
{
    int i;
    cout<<sum<<endl;
    for(i=1;i<n;i++)
    {
        cout<<x[i]<<" to => ";
    }cout<<x[n];
}

void GreedySkill()
{
    int i,j,xi,best;
    memset(d,0,sizeof(d));
    x[1]=1;
    d[1]=1;
    i=1;
    while(i<n)
    {
        i++;
        best=oo;
        for(j=1;j<=n;j++)
        {
            if((d[j]==0)&&(a[x[i-1]][j]<best))
            {
                best=a[x[i-1]][j];
                xi=j;
            }
        }
        x[i]=xi;
        d[xi]=1;
        sum+=a[x[i-1]][x[i]];
    }
    sum=sum+a[x[n]][x[1]];
}

int main()
{
    freopen("INPUT.INP","r",stdin);
    //freopen("OUTPUT.OUT","w",stdout);
    input();
    GreedySkill();
    output();
    return 0;
}
