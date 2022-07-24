#include <bits/stdc++.h>

using namespace std;
const int Max=29;
vector <int>x(Max),xs(Max);
int n,s,a[1500],sum=0,dem=0;
bool ok;

void input()
{
    cin>>n>>s;
    for(int i=1;i<=n;i++)cin>>a[i];
}

void check()
{
    if(sum==s)
    {
        for(int i=1;i<=n;i++)
        {
            xs[i]=x[i];
            if(xs[i]==1)dem++;
            ok=true;
        }
    }
}

void Backtrack(int i=1)
{
    for(int j=0;j<=1;j++)
    {
        x[i]=j;
        sum+=x[i]*a[i];
        if(i==n)check();
        else Backtrack(i+1);
        if(ok)return;
        sum-=x[i]*a[i];
    }
}

void output()
{
    cout<<dem<<endl;
    for(int i=1;i<=n;i++)
    {
        if(xs[i]==1)cout<<a[i]<<" ";
    }
    if(sum<s)cout<<"No";
}

int main()
{
    freopen("ATM.INP","r",stdin);
    //freopen("ATM.OUT","w",stdout);
    input();
    ok=false;
    Backtrack();
    output();
    return 0;
}
