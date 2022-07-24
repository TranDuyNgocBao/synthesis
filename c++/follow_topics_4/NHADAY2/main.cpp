#include <bits/stdc++.h>

using namespace std;
vector<long int>x(20);
long int d[1000],a,k,dem=0;

void Recordtest()
{
    long int i;
    for(i=1;i<=k;i++)
    {
        cout<<x[i]<<" ";
    }cout<<endl;
}

void Backtrack2(long int i)
{
    long int j;
    for(j=1;j<=a;j++)
    {
        if(d[j]==0)
        {
            x[i]=j;
            d[j]=1;
            if(i==k)dem++;
            else Backtrack2(i+1);
            d[j]=0;
        }
    }
}

void Backtrack(long int i)
{
    long int j;
    for(j=1;j<=a;j++)
    {
        if(d[j]==0)
        {
            x[i]=j;
            d[j]=1;
            if(i==k)Recordtest();
            else Backtrack(i+1);
            d[j]=0;
        }
    }
}



int main()
{
    cin>>a>>k;
    memset(d,0,1000);
    Backtrack2(1);
    cout<<dem<<endl;
    Backtrack(1);
    return 0;
}
